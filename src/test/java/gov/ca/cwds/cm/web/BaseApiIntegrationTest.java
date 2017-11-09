package gov.ca.cwds.cm.web;

import gov.ca.cwds.cm.CmApiApplication;
import gov.ca.cwds.cm.CmApiConfiguration;
import gov.ca.cwds.cm.web.rest.RestClientTestRule;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import java.time.format.DateTimeFormatter;
import javax.ws.rs.client.Client;
import org.glassfish.jersey.client.JerseyClient;
import org.junit.After;
import org.junit.ClassRule;
import org.junit.Rule;

/**
 * @author CWDS TPT-3 Team
 */
public abstract class BaseApiIntegrationTest {

  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter
      .ofPattern("yyyy-MM-dd HH:mm:ss");

  private static final String configFile = "config/test-case-management-api.yml";

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

  @Rule
  public RestClientTestRule clientTestRule = new RestClientTestRule(appRule);


  @After
  public void tearDown() throws Exception {
  }

    public String transformDTOtoJSON(Object o) throws Exception {
        return clientTestRule.getMapper().writeValueAsString(o);
    }

}
