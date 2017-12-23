package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.builder.ClientEntityAwareDTOBuilder;
import gov.ca.cwds.cm.service.dto.ClientDTO;
import gov.ca.cwds.cm.service.mapper.ClientMapper;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.cms.data.access.service.ClientCoreService;
import gov.ca.cwds.cms.data.access.service.DataAccessServicesException;
import gov.ca.cwds.data.legacy.cms.dao.ClientDao;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class ClientService extends CrudServiceAdapter {

  private ClientDao clientDao;
  private ClientMapper clientMapper;
  private ClientCoreService clientCoreService;

  @Inject
  public ClientService(
      ClientDao clientDao, ClientMapper clientMapper, ClientCoreService clientServiceCore) {
    this.clientMapper = clientMapper;
    this.clientDao = clientDao;
    this.clientCoreService = clientServiceCore;
  }

  @Override
  public ClientDTO find(Serializable serializable) {
    Client client = clientDao.find(((ClientParameterObject) serializable).getClientId());
    return clientMapper.toClientDTO(client);
  }

  //use this method at update() implementation
  protected Client updateClient(Client client) throws DataAccessServicesException {
    ClientEntityAwareDTOBuilder builder =
        new ClientEntityAwareDTOBuilder(client);
    ClientEntityAwareDTO clientEntityAwareDTO = builder.build();
    return clientCoreService.update(clientEntityAwareDTO);
  }
}
