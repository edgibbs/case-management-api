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
import gov.ca.cwds.security.annotations.Authorize;
import gov.ca.cwds.security.utils.PrincipalUtils;
import java.io.Serializable;
import java.time.LocalDateTime;

/** @author CWDS TPT-3 Team */
public class ChildClientService {

  private ChildClientMapper childClientMapper;
  private final ChildClientDao childClientDao;
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

  @Authorize("client:read:client")
  public ChildClient find(Serializable serializable) {
    return childClientDao.find(((ClientParameterObject) serializable).getClientId());
  }


  public Response update(Serializable serializable, Request request)
      throws DataAccessServicesException {
    ChildClient entity = childClientMapper.fromChildClientDTO((ChildClientDTO) request);
    LocalDateTime lastUpdate = LocalDateTime.now();
    entity.setIdentifier((String) serializable);
    entity.setLastUpdateTime(lastUpdate);
    entity.setLastUpdateId(PrincipalUtils.getStaffPersonId());
    entity.setChildClientLastUpdateId(PrincipalUtils.getStaffPersonId());
    entity.setChildClientLastUpdateTime(lastUpdate);
    ChildClient childClient = (ChildClient)updateClient(entity);
    return childClientMapper.toChildClientDTO(childClient);
  }

  private Client updateClient(Client client) throws DataAccessServicesException {
    ClientEntityAwareDTOBuilder builder = new ClientEntityAwareDTOBuilder(client);
    ClientEntityAwareDTO clientEntityAwareDTO = builder.build();
    return clientCoreService.update(clientEntityAwareDTO);
  }

}
