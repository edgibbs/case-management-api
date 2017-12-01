package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import gov.ca.cwds.cm.BaseApiIntegrationTest;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.cm.service.dto.search.criteria.CaseCriteriaDTO;
import gov.ca.cwds.cm.service.dto.search.result.CaseSearchResultDTO;
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
  public void searchMOCK_success_whenValidStaffId() throws Exception {
    // given
    final CaseCriteriaDTO input = CaseCriteriaDTO.builder().staffId("q58").build();

    // when
    final Response response = clientTestRule
        .target(Constants.API.CASES + "/" + API.SEARCH)
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(input, MediaType.APPLICATION_JSON));
    final CaseSearchResultDTO actual = response.readEntity(CaseSearchResultDTO.class);

    // then
    assertEqualsResponse(
        transformDTOtoJSON(actual),
        fixture("fixtures/cases-by-staff-id-mock.json")
    );
  }

  @Test
  public void searchMOCK_empty_whenUnknownStaffId() throws Exception {
    // given
    final CaseCriteriaDTO input = CaseCriteriaDTO.builder().staffId("Unknown").build();

    // when
    final Response response = clientTestRule
        .target(Constants.API.CASES + "/" + API.SEARCH)
        .request(MediaType.APPLICATION_JSON)
        .post(Entity.entity(input, MediaType.APPLICATION_JSON));
    final CaseSearchResultDTO actual = response.readEntity(CaseSearchResultDTO.class);

    // then
    assertThat(actual.getResults(), is(notNullValue()));
    assertThat(actual.getResults().size(), is(equalTo(0)));
    assertThat(actual.getTotalRecords(), is(equalTo(0L)));
  }
}
