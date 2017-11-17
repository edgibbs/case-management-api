package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.web.rest.utils.AssertFixtureUtils.assertResponseByFixturePath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.web.BaseApiIntegrationTest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author CWDS TPT-3 Team
 */
public class SystemCodeResourceTest extends BaseApiIntegrationTest {

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpDb();
    runScript("liquibase/system_code/ddl_sys_cd_c.xml");
    runScript("liquibase/system_code/dml_system_code.xml");
  }

  @Test
  public void find_success_whenExists() throws Exception {
    // when
    final Response actualResult = clientTestRule.target(API.SYSTEM_CODES + "/GVR_ENTC")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Response.class);

    // then
    assertResponseByFixturePath(
        actualResult,
        "fixtures/systemCode/find_success_response.json"
    );
  }

  @Test
  public void find_notFound_whenNoRecordsWithTheCodeExist() throws Exception {
    // when
    final Response actualResult = clientTestRule.target(API.SYSTEM_CODES + "/NotExistentCode")
        .request(MediaType.APPLICATION_JSON_TYPE)
        .get(Response.class);

    // then
    assertThat(actualResult.getStatus(), is(equalTo(404)));
  }

}
