package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

public class CaseResourceTest extends BaseApiIntegrationTest {

  public static final String CASE_ID = "ArgnUzi09L";

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
  }

  @Test
  public void testGetCaseById() throws Exception {
    WebTarget target = clientTestRule.target(Constants.API.CASES + "/" + CASE_ID);
    Response response = target.request(MediaType.APPLICATION_JSON).get();
    CaseDTO caseDTO = response.readEntity(CaseDTO.class);
    String fixture = fixture("fixtures/case-by-id-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(caseDTO));
  }

  @Test
  public void testUpdateCase() throws Exception {
    CaseDTO caseDTO = new CaseDTO();

    caseDTO.setId("CWulvpU0JY");//may be not equal to parameter ID
    caseDTO.setAlertText("EssaJ4W0Js");
    caseDTO.setApprovalNumber("GIxeGnJ00u");
    caseDTO.setApprovalStatus((short) 118);
    caseDTO.setCaseClosureReason((short) 306);
    caseDTO.setCaseplanChildrenDetail(true);
    caseDTO.setClosureStatementText("Fn3lUdY00F");
    caseDTO.setCountry((short) 563);
    caseDTO.setCountySpecificCode("10");
    caseDTO.setDrmsNotesDoc("At9HoSn0WJ");
    caseDTO.setEmancipationDate(localDate("2018-10-20"));
    caseDTO.setEndDate(localDate("2018-10-20"));
    caseDTO.setChildClient("8m7hS7i07n");
    caseDTO.setReferralId("7Rgxy9S00T");
    caseDTO.setStaffPerson("07n");
    caseDTO.setCounty((short) 1068);
    caseDTO.setIcpcOutgoingPlacementStatus(true);
    caseDTO.setIcpcOutgoingRequest(true);
    caseDTO.setLimitedAccess("N");
    caseDTO.setLimitedAccessDesc("Text");
    caseDTO.setLimitedAccessCounty((short) 1068);
    caseDTO.setCaseName("Sibling Hanson");
    caseDTO.setNextTilpDueDate(localDate("2018-10-24"));
    caseDTO.setProjectedEndDate(localDate("2018-10-23"));
    caseDTO.setResponsibleAgency("A");
    caseDTO.setSpecialProjectCase(true);
    caseDTO.setStartDate(localDate("2016-10-23"));
    caseDTO.setState((short) 1828);
    caseDTO.setActiveServiceComponent((short) 1692);
    caseDTO.setActiveServiceComponentStartDate(localDate("2016-10-23"));
    caseDTO.setTickle(true);

    WebTarget target = clientTestRule.target(API.CASES + "/" + CASE_ID);
    CaseDTO response =
        target
            .request(MediaType.APPLICATION_JSON_TYPE)
            .put(Entity.entity(caseDTO, MediaType.APPLICATION_JSON_TYPE), CaseDTO.class);

    String fixture = fixture("fixtures/case-after-update-response.json");
    assertEqualsResponse(fixture, transformDTOtoJSON(response));
  }
}
