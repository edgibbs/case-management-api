package gov.ca.cwds.cm.service.builder;

import gov.ca.cwds.cms.data.access.builder.EntityAwareDTOBuilder;
import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.data.legacy.cms.entity.Client;

public class ClientEntityAwareDTOBuilder
    implements EntityAwareDTOBuilder<Client, ClientEntityAwareDTO> {

  private final ClientEntityAwareDTO dto;

  public ClientEntityAwareDTOBuilder(Client client) {
    dto = new ClientEntityAwareDTO();
    dto.setEntity(client);
  }

  @Override
  public ClientEntityAwareDTO build() {
    return dto;
  }
}
