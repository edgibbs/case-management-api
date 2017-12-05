package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertFixtureUtils.assertResponseByFixturePath;
import static org.assertj.core.api.Assertions.fail;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.Constants.API;
import java.util.List;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

/** @author CWDS TPT-3 Team */
public class StafPersonResourceTest extends BaseApiIntegrationTest {

  public static final String STAFF_PERSON_ID = "q48";
  public static final String WRONG_STAFF_PERSON_ID = "-1";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
  }

  @Test
  public void testGetClientsByStaffId() throws Exception {
    WebTarget target =
        clientTestRule.target(Constants.API.STAFF + "/" + STAFF_PERSON_ID + "/clients");
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    assertResponseByFixturePath(response, "fixtures/list_of_related_clients_by_staff_id.json");
  }

  @Test
  public void testGetClientsByWrongStaffId() {
    WebTarget target =
        clientTestRule.target(Constants.API.STAFF + "/" + WRONG_STAFF_PERSON_ID + "/clients");
    Invocation.Builder invocation = target.request(MediaType.APPLICATION_JSON);
    try {
      invocation.get(List.class);
      fail("Correct response is not expected");
    } catch (NotFoundException e) {
      Assertions.assertThat("HTTP 404 Not Found").isEqualTo(e.getMessage());
    }
  }

  @Test
  public void getReferralsByStaffIdTest() throws Exception {
    WebTarget target =
        clientTestRule.target(API.STAFF + "/" + STAFF_PERSON_ID + "/" + API.REFERRALS);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    assertResponseByFixturePath(response, "fixtures/referrals_by_staff_id.json");
  }

  @Test
  public void getReferralsByWrongStaffIdTest() {
    WebTarget target =
        clientTestRule.target(API.STAFF + "/" + WRONG_STAFF_PERSON_ID + "/" + API.REFERRALS);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    assertThat(response.getStatus()).isEqualTo(Status.NOT_FOUND.getStatusCode());
  }
}
