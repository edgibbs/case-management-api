package gov.ca.cwds.cm.web.rest.parameter;

import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class ChildClientParameterObject implements Serializable {

  private static final long serialVersionUID = 1235598994686585318L;

  private String childClientId;

  public String getChildClientId() {
    return childClientId;
  }

  public void setChildClientId(String childClientId) {
    this.childClientId = childClientId;
  }
}
