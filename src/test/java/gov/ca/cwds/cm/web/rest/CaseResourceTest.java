package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.cm.web.BaseApiIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.web.rest.utils.AssertResponseHelper.assertEqualsResponse;
import static io.dropwizard.testing.FixtureHelpers.fixture;

public class CaseResourceTest extends BaseApiIntegrationTest {

	public static final String CASE_ID = "ArgnUzi09L";

	@BeforeClass
	public static void beforeClass() throws Exception {
		setUpDb();
	}

	@Test
	public void testGetCaseById() throws Exception {
		WebTarget target = clientTestRule.target(Constants.API.CASE + "/" + CASE_ID);
		Response response = target.request(MediaType.APPLICATION_JSON).get();
		CaseDTO caseDTO = response.readEntity(CaseDTO.class);
		String fixture = fixture("fixtures/case-by-id-response.json");
		assertEqualsResponse(fixture, transformDTOtoJSON(caseDTO));
	}
}
