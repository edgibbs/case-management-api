package gov.ca.cwds.cm.service.dto;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class BaseClientDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 6306525014938361213L;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private ClientDTO client;

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
