package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.persistence.model.ClientAddress;
import gov.ca.cwds.cm.service.dto.ClientAddressDTO;
import gov.ca.cwds.cm.service.mapper.tool.LegacyBooleanToStringMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS TPT-3 Team
 */

@Mapper(uses = { LegacyBooleanToStringMapper.class, AddressMapper.class })
public interface ClientAddressMapper {

  @Mapping(target = "messages", ignore = true)
  @Mapping(source = "bkInmtId", target = "bookingOrInmateId")
  @Mapping(source = "effEndDt", target = "effectiveEndDate")
  @Mapping(source = "effStartDt", target = "effectiveStartDate")
  @Mapping(source = "homelessInd", target = "homelessIndicator")
  @Mapping(source = "fkClient", target = "clientId")
  @Mapping(source = "fkReferral", target = "referralId")
  ClientAddressDTO toDto(ClientAddress clientAddress);

  @InheritInverseConfiguration
  @Mapping(target = "fkAddress", ignore = true)
  @Mapping(target = "lastUpdatedId", ignore = true)
  @Mapping(target = "lastUpdatedTime", ignore = true)
  ClientAddress toEntity(ClientAddressDTO clientAddressDTO);

}
