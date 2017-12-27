package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.builder.ClientEntityAwareDTOBuilder;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.cms.data.access.service.ClientCoreService;
import gov.ca.cwds.cms.data.access.service.DataAccessServicesException;
import gov.ca.cwds.data.legacy.cms.dao.ChildClientDao;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;

import gov.ca.cwds.data.legacy.cms.entity.Client;
import gov.ca.cwds.rest.api.Request;
import gov.ca.cwds.rest.api.Response;
import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class ChildClientService extends CrudServiceAdapter {

  private ChildClientDao childClientDao;
  private ChildClientMapper childClientMapper;
  private ClientCoreService clientCoreService;

  @Inject
  public ChildClientService(
      ChildClientDao childClientDao,
      ChildClientMapper childClientMapper,
      ClientCoreService clientCoreService) {
    this.childClientDao = childClientDao;
    this.childClientMapper = childClientMapper;
    this.clientCoreService = clientCoreService;
  }

  @Override
  public ChildClientDTO find(Serializable serializable) {
    ChildClient childClient =
        childClientDao.find(((ClientParameterObject) serializable).getClientId());
    return childClientMapper.toChildClientDTO(childClient);
  }

  @Override
  public Response update(Serializable serializable, Request request) {
    ChildClient entity = childClientMapper.fromChildClientDTO((ChildClientDTO) request);
    ChildClient childClient = (ChildClient)updateClient(entity);
    return childClientMapper.toChildClientDTO(childClient);
  }

  private Client updateClient(Client client) {
    ClientEntityAwareDTOBuilder builder = new ClientEntityAwareDTOBuilder(client);
    ClientEntityAwareDTO clientEntityAwareDTO = builder.build();
    try {
      return clientCoreService.update(clientEntityAwareDTO);
    } catch (DataAccessServicesException e) {
      throw new RuntimeException(e);
    }
  }
}
