package gov.ca.cwds.cm;

import gov.ca.cwds.cm.web.BaseApiIntegrationTest;
import liquibase.exception.LiquibaseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/** @author CWDS TPT-3 Team */
public class DatabaseHelperTest extends BaseApiIntegrationTest {

  DatabaseHelper helper;

  @BeforeClass
  public static void beforeClass() throws Exception {
    setUpCms();
    setUpDb();
  }

  @Before
  public void before() {
    helper = getDatabaseHelper();
  }

  @Test
  public void runScript() throws Exception {
    Map<String, Object> params = new HashMap<>();
    helper.runScript("liquibase/test_database_master.xml", params, null);

    try {
      helper.runScript("liquibase/test_database_master.xml", params, "");
      Assert.fail();
    } catch (LiquibaseException e) {
      // expected
    }
  }
}
