package gov.ca.cwds.cm.persistence.dao;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import gov.ca.cwds.cm.persistence.model.ClientAddress;
import gov.ca.cwds.cm.util.Require;
import gov.ca.cwds.data.BaseDaoImpl;
import gov.ca.cwds.inject.CmsSessionFactory;
import java.util.Collection;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 * @author CWDS TPT-3 Team
 */
public class ClientAddressDao extends BaseDaoImpl<ClientAddress> {

  @Inject
  public ClientAddressDao(@CmsSessionFactory final SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public Collection<ClientAddress> findByClientId(final String clientId) {
    Require.requireNotNullAndNotEmpty(clientId);

    final List<ClientAddress> clientAddresses = this.getSessionFactory().getCurrentSession()
        .createNamedQuery(ClientAddress.NQ_FIND_BY_CLIENT_ID, ClientAddress.class)
        .setParameter(ClientAddress.NQ_PARAM_CLIENT_ID, clientId)
        .list();

    return ImmutableList.<ClientAddress>builder()
        .addAll(clientAddresses)
        .build();
  }

}
