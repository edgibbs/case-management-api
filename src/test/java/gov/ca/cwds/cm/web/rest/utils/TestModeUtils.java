package gov.ca.cwds.cm.web.rest.utils;

/**
 * @author CWDS TPT-3 Team
 */
public class TestModeUtils {

  public static final String API_URL = "api.url";

  private TestModeUtils() {
  }

  public static boolean isIntegrationTestsMode() {
    return System.getProperty(API_URL) != null;
  }
}
