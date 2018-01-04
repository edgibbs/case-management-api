package gov.ca.cwds.cm;

import gov.ca.cwds.cm.web.rest.RestClientTestRule;
import gov.ca.cwds.cm.web.rest.utils.TestModeUtils;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClient;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;

/** @author CWDS TPT-3 Team */
public abstract class BaseApiIntegrationTest {

  public static final int UNPROCESSABLE_ENTITY_STATUS_CODE = 422;

  private static final DateTimeFormatter DATE_TIME_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

  private static final String configFile = "config/test-case-management-api.yml";

  public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @ClassRule
  public static final DropwizardAppRule<CmApiConfiguration> appRule =
      new DropwizardAppRule<CmApiConfiguration>(
          CmApiApplication.class, ResourceHelpers.resourceFilePath(configFile)) {

        @Override
        public Client client() {
          Client client = super.client();
          if (((JerseyClient) client).isClosed()) {
            client = clientBuilder().build();
          }
          return client;
        }
      };

  @Rule public RestClientTestRule clientTestRule = new RestClientTestRule(appRule);

  @After
  public void tearDown() throws Exception {}

  public String transformDTOtoJSON(Object o) throws Exception {
    return clientTestRule.getMapper().writeValueAsString(o);
  }

  protected static DatabaseHelper getCmsDatabaseHelper() {
    return createDatabaseHelper(appRule.getConfiguration().getCmsDataSourceFactory());
  }

  protected static DatabaseHelper getRsDatabaseHelper() {
    return createDatabaseHelper(appRule.getConfiguration().getCwsRsDataSourceFactory());
  }

  private static DatabaseHelper createDatabaseHelper(DataSourceFactory dataSourceFactory) {
    return new DatabaseHelper(
        dataSourceFactory.getUrl(),
        dataSourceFactory.getUser(),
        dataSourceFactory.getPassword()
    );
  }

  public static void setUpCms() throws Exception {
    if (!TestModeUtils.isIntegrationTestsMode()) {
      getCmsDatabaseHelper().runScript("liquibase/cwscms_database_master.xml");
    }
  }

  public static void setUpCwsRs1() throws Exception {
    if (!TestModeUtils.isIntegrationTestsMode()) {
      getRsDatabaseHelper().runScript("liquibase/cwsrs1-database-master.xml");
    }
  }

  public static void setUpDb() throws Exception {
    if (!TestModeUtils.isIntegrationTestsMode()) {
      getCmsDatabaseHelper().runScript("liquibase/migration_master.xml");
    }
  }

  public static void runScripts(final String... scriptPaths) throws Exception {
    if (!TestModeUtils.isIntegrationTestsMode()) {
      final DatabaseHelper databaseHelper = getCmsDatabaseHelper();
      for (String path : scriptPaths) {
        databaseHelper.runScript(path);
      }
    }
  }

  public static LocalDate localDate(String dateStr) {
    return LocalDate.parse(dateStr, DATE_FORMATTER);
  }
}
