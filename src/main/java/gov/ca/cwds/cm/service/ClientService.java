package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.data.legacy.cms.dao.ClientDao;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import gov.ca.cwds.security.annotations.Authorize;
import java.io.Serializable;

/**
 * @author CWDS TPT-3 Team
 */
public class ClientService {

  private final ClientDao clientDao;

  @Inject
  public ClientService(ClientDao clientDao) {
    this.clientDao = clientDao;
  }

  @Authorize("client:read:client")
  public Client find(Serializable serializable) {
    return clientDao.find(((ClientParameterObject) serializable).getClientId());
  }

  public Client update(Client entity) {
    return clientDao.update(entity);
  }
}
