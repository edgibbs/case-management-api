package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.builder.ClientEntityAwareDTOBuilder;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.cms.data.access.service.ClientCoreService;
import gov.ca.cwds.cms.data.access.service.DataAccessServicesException;
import gov.ca.cwds.data.legacy.cms.dao.ChildClientDao;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import gov.ca.cwds.security.annotations.Authorize;
import java.io.Serializable;

/** @author CWDS TPT-3 Team */
public class ChildClientService {

  private final ChildClientDao childClientDao;
  private final ClientCoreService clientCoreService;

  @Inject
  public ChildClientService(
      ChildClientDao childClientDao,
      ClientCoreService clientCoreService) {
    this.childClientDao = childClientDao;
    this.clientCoreService = clientCoreService;
  }

  @Authorize("client:read:client")
  public ChildClient find(Serializable serializable) {
    return childClientDao.find(((ClientParameterObject) serializable).getClientId());
  }

  public ChildClient update(ChildClient childClient) {
    final ClientEntityAwareDTO clientEntityAwareDTO = new ClientEntityAwareDTOBuilder(childClient)
        .build();
    try {
      return (ChildClient) clientCoreService.update(clientEntityAwareDTO);
    } catch (DataAccessServicesException e) {
      throw new RuntimeException(e);
    }
  }
}
