package gov.ca.cwds.cm.service.builder;

import gov.ca.cwds.cms.data.access.builder.EntityAwareDTOBuilder;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.cms.data.access.utils.PerryUtils;

public class ClientEntityAwareDTOBuilder implements
    EntityAwareDTOBuilder<Client, ClientEntityAwareDTO> {

  @Override
  public ClientEntityAwareDTO build(){
      return new ClientEntityAwareDTO(PerryUtils.getPerryAccount());
  }
}
