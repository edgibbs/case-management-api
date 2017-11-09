package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.web.BaseApiIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;

/** @author CWDS TPT-3 Team */
public class ChildClientResourceTest extends BaseApiIntegrationTest {

  public static final String CASE_NUMBER = "1";

  @BeforeClass
  public static void beforeClass() throws Exception {}

  @Test
  public void testGetChildClientById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CHILD_CLIENT + "/" + CASE_NUMBER);
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON_TYPE);
    ChildClientDTO childClientDTO = invocation.get(ChildClientDTO.class);

    String fixture = fixture("fixtures/child-client-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(childClientDTO));
  }
}
