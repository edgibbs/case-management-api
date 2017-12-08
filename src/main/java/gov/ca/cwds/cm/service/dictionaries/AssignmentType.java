package gov.ca.cwds.cm.service.dictionaries;

/**
 * @author CWDS TPT-3 Team
 */
public enum AssignmentType {
  PRIMARY('P'),
  SECONDARY('S'),
  READ_ONLY('R');

  AssignmentType(Character code) {
    this.code = code;
  }

  private Character code;

  public static AssignmentType from(Character type) {
    if (PRIMARY.code.equals(type)) {
      return PRIMARY;
    } else if (SECONDARY.code.equals(type)) {
      return SECONDARY;
    } else if (READ_ONLY.code.equals(type)) {
      return READ_ONLY;
    }

    throw new RuntimeException("Unknown type");
  }
}
