package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.service.exception.BuisenessValidationException;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.cms.data.access.dto.ChildClientEntityAwareDTO;
import gov.ca.cwds.cms.data.access.service.DataAccessServicesException;
import gov.ca.cwds.cms.data.access.service.impl.ChildClientCoreServiceImpl;
import gov.ca.cwds.data.legacy.cms.dao.ChildClientDao;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import gov.ca.cwds.drools.DroolsException;
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
  private ChildClientCoreServiceImpl childClientCoreService;

  @Inject
  public ChildClientService(
      ChildClientDao childClientDao,
      ChildClientMapper childClientMapper,
      ChildClientCoreServiceImpl clientCoreService) {
    this.childClientDao = childClientDao;
    this.childClientMapper = childClientMapper;
    this.childClientCoreService = clientCoreService;
  }

  @Authorize("client:read:client")
  public ChildClient find(Serializable serializable) {
    return childClientDao.find(((ClientParameterObject) serializable).getClientId());
  }

  public Response update(Serializable serializable, Request request)
      throws DataAccessServicesException {
    String staffPersonId = PrincipalUtils.getStaffPersonId();
    ChildClient entity = childClientMapper.fromChildClientDTO((ChildClientDTO) request);
    LocalDateTime lastUpdate = LocalDateTime.now();
    entity.setIdentifier((String) serializable);
    entity.setLastUpdateTime(lastUpdate);
    entity.setLastUpdateId(staffPersonId);
    entity.setChildClientLastUpdateId(staffPersonId);
    entity.setChildClientLastUpdateTime(lastUpdate);
    ChildClient childClient = null;
    childClient = (ChildClient) updateClient(entity);

    return childClientMapper.toChildClientDTO(childClient);
  }

  private Client updateClient(Client client) throws DataAccessServicesException {
    ChildClientEntityAwareDTO clientEntityAwareDTO = new ChildClientEntityAwareDTO();
    clientEntityAwareDTO.setEntity(client);
    try {
      return childClientCoreService.update(clientEntityAwareDTO);
    } catch (DroolsException e) {
      throw new BuisenessValidationException(e);
    }
  }
}
