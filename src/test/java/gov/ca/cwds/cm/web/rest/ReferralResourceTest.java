package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertFixtureUtils.assertResponseByFixturePath;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.service.dto.search.criteria.ReferralSearchCriteria;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.junit.BeforeClass;
import org.junit.Test;

/** @author CWDS TPT-3 Team */
public class ReferralResourceTest extends BaseApiIntegrationTest {

  public static final String STAFF_PERSON_ID = "ddeerrfdsf";
  public static final String WRONG_STAFF_PERSON_ID = "-1";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
    //    runScripts("liquibase/client/client_test_get_for_client_endpoint.xml");
  }

  @Test
  public void getReferralsByStaffIdTest() throws Exception {
    WebTarget target = clientTestRule.target(API.REFERRAL + "/_search");
    ReferralSearchCriteria searchCriteria = new ReferralSearchCriteria();
    searchCriteria.setStaffId(STAFF_PERSON_ID);
    Response response =
        target
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(searchCriteria, MediaType.APPLICATION_JSON_TYPE));
    assertResponseByFixturePath(response, "fixtures/referrals_by_staff_id.json");
  }

  @Test
  public void getReferralsByWrongStaffIdTest() {
    WebTarget target = clientTestRule.target(API.REFERRAL + "/_search");
    ReferralSearchCriteria searchCriteria = new ReferralSearchCriteria();
    searchCriteria.setStaffId(WRONG_STAFF_PERSON_ID);
    Response response =
        target
            .request(MediaType.APPLICATION_JSON)
            .post(Entity.entity(searchCriteria, MediaType.APPLICATION_JSON_TYPE));
    assertThat(response.getStatus()).isEqualTo(Status.NOT_FOUND.getStatusCode());
  }
}
