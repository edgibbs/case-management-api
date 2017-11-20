package gov.ca.cwds.cm.persistence.dao;

import com.google.inject.Inject;
import gov.ca.cwds.cm.persistence.model.Address;
import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.inject.CmsSessionFactory;
import org.hibernate.SessionFactory;

/**
 * @author CWDS TPT-3 Team
 */
public class AddressDao extends BaseDaoImpl<Address> {

  @Inject
  public AddressDao(@CmsSessionFactory final SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
