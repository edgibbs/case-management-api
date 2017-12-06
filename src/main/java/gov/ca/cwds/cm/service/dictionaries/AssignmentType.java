package gov.ca.cwds.cm.service.dictionaries;

/**
 * @author CWDS TPT-3 Team
 */
public enum AssignmentType {
  PRIMARY("P"),
  SECONDARY("S"),
  READ_ONLY("R");

  AssignmentType(String type) {
    this.type = type;
  }

  private String type;

  public static AssignmentType from(String type) {
    if (PRIMARY.type.equals(type)) {
      return PRIMARY;
    } else if (SECONDARY.type.equals(type)) {
      return SECONDARY;
    } else if (READ_ONLY.type.equals(type)) {
      return READ_ONLY;
    }

    throw new RuntimeException("Unknown type");
  }
}
