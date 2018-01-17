package gov.ca.cwds.cm.service.exception;

/**
 * @author CWDS TPT-3 Team
 */
public class BuisenessValidationException extends RuntimeException {

  private static final long serialVersionUID = 6453078047667415739L;

  public BuisenessValidationException() {
  }

  public BuisenessValidationException(Exception e) {
    super(e);
  }
}
