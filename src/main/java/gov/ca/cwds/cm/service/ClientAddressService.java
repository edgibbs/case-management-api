package gov.ca.cwds.cm.service;

import gov.ca.cwds.cm.persistence.dao.ClientAddressDao;
import gov.ca.cwds.cm.persistence.model.ClientAddress;
import gov.ca.cwds.cm.service.dto.ClientAddressDTO;
import gov.ca.cwds.cm.service.dto.CollectionDTO;
import gov.ca.cwds.cm.service.mapper.ClientAddressMapper;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;

/**
 * @author CWDS TPT-3 Team
 */
public class ClientAddressService extends CrudServiceAdapter {

  private final ClientAddressDao clientAddressDao;
  private final ClientAddressMapper clientAddressMapper;

  @Inject
  public ClientAddressService(
      final ClientAddressDao clientAddressDao,
      final ClientAddressMapper clientAddressMapper) {
    this.clientAddressDao = clientAddressDao;
    this.clientAddressMapper = clientAddressMapper;
  }

  public CollectionDTO<ClientAddressDTO> findByClientId(final String clientId) {
    final Collection<ClientAddress> addresses = clientAddressDao.findByClientId(clientId);

    final List<ClientAddressDTO> dtos = addresses.stream()
        .map(clientAddressMapper::toDto)
        .collect(Collectors.toList());

    return CollectionDTO.<ClientAddressDTO>builder()
        .items(dtos)
        .build();
  }

}
