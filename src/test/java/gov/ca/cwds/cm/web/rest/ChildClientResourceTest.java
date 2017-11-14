package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.web.BaseApiIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;

/** @author CWDS TPT-3 Team */
public class ChildClientResourceTest extends BaseApiIntegrationTest {

  public static final String CLIENT_ID = "BKk7CHj00Z";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpDb();
  }

  @Test
  public void testGetChildClientById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CHILD_CLIENT + "/" + CLIENT_ID);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    ChildClientDTO childClientDTO = response.readEntity(ChildClientDTO.class);

    String fixture = fixture("fixtures/child-client-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(childClientDTO));
  }
}
