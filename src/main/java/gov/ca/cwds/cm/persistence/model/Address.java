package gov.ca.cwds.cm.persistence.model;

import gov.ca.cwds.data.persistence.PersistentObject;
import gov.ca.cwds.data.persistence.cms.BaseAddress;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * {@link PersistentObject} representing an Address
 * 
 * @author CWDS TPT-3 Team
 */
@Entity
@Table(name = "ADDRS_T")
public class Address extends BaseAddress {

  private static final long serialVersionUID = 1L;

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this, false);
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj, false);
  }
}
