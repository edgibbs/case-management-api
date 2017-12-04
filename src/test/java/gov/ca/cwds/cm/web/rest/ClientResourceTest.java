package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertFixtureUtils.assertResponseByFixturePath;
import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.assertj.core.api.Assertions.assertThat;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.ClientDTO;
import gov.ca.cwds.cm.service.dto.search.criteria.ClientsSearchCriteriaDTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.junit.BeforeClass;
import org.junit.Test;

/** @author CWDS TPT-3 Team */
public class ClientResourceTest extends BaseApiIntegrationTest {

  public static final String CLIENT_ID = "22223312D";
  public static final String CASEWORKER_ID = "q48";
  public static final String WRONG_CASEWORKER_ID = "-1";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
    runScripts("liquibase/client/client_test_get_for_client_endpoint.xml");
  }

  @Test
  public void testGetChildClientById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CLIENTS + "/" + CLIENT_ID);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    ClientDTO clientDTO = response.readEntity(ClientDTO.class);

    String fixture = fixture("fixtures/client-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(clientDTO));
  }

  @Test
  public void testGetCaseById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CLIENTS + "/_search");
    ClientsSearchCriteriaDTO searchCriteria = new ClientsSearchCriteriaDTO(CASEWORKER_ID);
    Response response =
        target
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(searchCriteria, MediaType.APPLICATION_JSON_TYPE));
    assertResponseByFixturePath(response, "fixtures/list_of_related_clients_by_staff_id.json");
  }

  @Test
  public void testGetBaseByWrongId() {
    WebTarget target = clientTestRule.target(Constants.API.CLIENTS + "/_search");
    ClientsSearchCriteriaDTO searchCriteria = new ClientsSearchCriteriaDTO(WRONG_CASEWORKER_ID);
    Response response =
        target
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(searchCriteria, MediaType.APPLICATION_JSON_TYPE));
    assertThat(response.getStatus()).isEqualTo(Status.NOT_FOUND.getStatusCode());
  }
}
