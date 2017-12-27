package gov.ca.cwds.cm.service.facade;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.ChildClientService;
import gov.ca.cwds.cm.service.ClientService;
import gov.ca.cwds.cm.service.dictionaries.ClientType;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;
import gov.ca.cwds.cm.service.mapper.ClientMapper;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class ClientFacade {

  private final ClientService clientService;
  private final ClientMapper clientMapper;
  private final ChildClientService childClientService;
  private final ChildClientMapper childClientMapper;

  @Inject
  public ClientFacade(ClientService clientService, ClientMapper clientMapper,
      ChildClientService childClientService, ChildClientMapper childClientMapper) {
    this.clientService = clientService;
    this.clientMapper = clientMapper;
    this.childClientService = childClientService;
    this.childClientMapper = childClientMapper;
  }

  public Response find(Serializable serializable, ClientType clientType) {
    if (clientType == null) {
      return null;
    }

    switch (clientType) {
      case BASE_CLIENT:
        return findClient(serializable);
      case CHILD_CLIENT:
        return findChildClient(serializable);
      default:
        return null;
    }
  }

  private Response findClient(Serializable serializable) {
    final Client client = clientService.find(serializable);
    return clientMapper.toClientDTO(client);
  }

  private Response findChildClient(Serializable serializable) {
    final ChildClient childClient = childClientService.find(serializable);
    return childClientMapper.toChildClientDTO(childClient);
  }

  public void update(Serializable serializable, ClientType clientType) {
    switch (clientType) {
      case BASE_CLIENT:
        clientService.update(serializable);
        break;
      case CHILD_CLIENT:
        childClientService.update(serializable, null);
        break;
    }
  }
}
