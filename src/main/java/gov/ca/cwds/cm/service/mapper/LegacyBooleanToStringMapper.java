package gov.ca.cwds.cm.service.mapper;

/**
 * @author CWDS TPT-3 Team
 */
public class LegacyBooleanToStringMapper {

  public static final String Y = "Y";
  public static final String N = "N";

  public Boolean toBoolean(final String inputString) {
    Boolean result = null;
    if (Y.equalsIgnoreCase(inputString)) {
      result = Boolean.TRUE;
    } else if (N.equalsIgnoreCase(inputString)) {
      result = Boolean.FALSE;
    }
    return result;
  }

  public String toString(final Boolean inputBoolean) {
    if (inputBoolean == null) {
      return null;
    }
    return inputBoolean? Y : N;
  }

}
