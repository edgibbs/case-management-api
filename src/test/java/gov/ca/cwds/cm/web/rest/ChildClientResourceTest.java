package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
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
//        "liquibase/address/ddl_addrs_t.xml",
        "liquibase/address/dml_address_test_data.xml",
//        "liquibase/client/address/ddl_cl_addr_t.xml",
        "liquibase/client/address/dml_client_address_test_data.xml"
    );
  }

  @Test
  public void testGetChildClientById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CHILD_CLIENT + "/" + CLIENT_ID);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    ChildClientDTO childClientDTO = response.readEntity(ChildClientDTO.class);

    String fixture = fixture("fixtures/child-client-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(childClientDTO));
  }

  @Test
  public void getAddressesByClientId_success_whenAddressesExist() throws Exception {
    // when
    final Response actualResult = clientTestRule.target(Constants.API.CHILD_CLIENT + "/GmNMeSx0Hy/addresses")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Response.class);

    // then
    assertResponseByFixturePath(
        actualResult,
        "fixtures/child-client/getAddressesByClientId_success_whenAddressesExist.json"
    );
  }

  @Test
  public void getAddressesByClientId_code404_whenNoAddress() throws Exception {
    // when
    final Response actualResult = clientTestRule.target(Constants.API.CHILD_CLIENT + "/NotExistingId/addresses")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Response.class);

    // then
    assertThat(actualResult.getStatus(), is(equalTo(404)));
  }
}
