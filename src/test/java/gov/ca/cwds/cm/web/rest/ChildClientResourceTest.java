package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import javax.ws.rs.client.Entity;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.web.rest.utils.AssertFixtureUtils.assertResponseByFixturePath;
import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/** @author CWDS TPT-3 Team */
public class ChildClientResourceTest extends BaseApiIntegrationTest {

  public static final String CLIENT_ID = "BKk7CHj00Z";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
    runScripts(
        "liquibase/address/dml_address_test_data.xml",
        "liquibase/client/address/dml_client_address_test_data.xml",
        "liquibase/client/child_client_test_update.xml"
        );
  }

  @Test
  public void testGetChildClientById() throws Exception {
    ChildClientDTO childClientDTO = getChildClientDTO(CLIENT_ID);

    String fixture = fixture("fixtures/child-client-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(childClientDTO));
  }

  @Test
  public void testUpdateChildClient() throws Exception {
    ChildClientDTO childClientDTO = getChildClientDTO("BKk7CHj00A");
    childClientDTO.setAdoptableCode("Y");

    WebTarget target = clientTestRule.target(API.CHILD_CLIENTS + "/BKk7CHj00A");
    ChildClientDTO response =
        target
            .request(MediaType.APPLICATION_JSON_TYPE)
            .put(Entity.entity(childClientDTO, MediaType.APPLICATION_JSON_TYPE), ChildClientDTO.class);

    childClientDTO = getChildClientDTO("BKk7CHj00A");

    String fixture = fixture("fixtures/child-client-after-update-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(childClientDTO));
  }

  @Test
  public void getAddressesByClientId_success_whenAddressesExist() throws Exception {
    // given
    final String path = API.CHILD_CLIENTS + "/GmNMeSx0Hy/" + API.ADDRESSES;

    // when
    final Response actualResult =
        clientTestRule.target(path).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);

    // then
    assertResponseByFixturePath(
        actualResult,
        "fixtures/child-client/getAddressesByClientId_success_whenAddressesExist.json");
  }

  @Test
  public void getAddressesByClientId_code404_whenNoAddress() throws Exception {
    // given
    final String path = API.CHILD_CLIENTS + "/NotExistingId/" + API.ADDRESSES;

    // when
    final Response actualResult =
        clientTestRule.target(path).request(MediaType.APPLICATION_JSON_TYPE).get(Response.class);

    // then
    assertThat(actualResult.getStatus(), is(equalTo(404)));
  }

  private ChildClientDTO getChildClientDTO(String clientId) {
    WebTarget target = clientTestRule.target(API.CHILD_CLIENTS + "/" + clientId);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    return response.readEntity(ChildClientDTO.class);
  }
}
