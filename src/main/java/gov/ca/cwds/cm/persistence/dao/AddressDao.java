package gov.ca.cwds.cm.persistence.dao;

import com.google.inject.Inject;
import gov.ca.cwds.cm.persistence.model.Address;
import gov.ca.cwds.data.BaseDaoImpl;
import lombok.extern.java.Log;
import org.hibernate.SessionFactory;

/**
 * @author CWDS TPT-3 Team
 */
@Log
public class AddressDao extends BaseDaoImpl<Address> {

  @Inject
  public AddressDao(final SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
