package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.persistence.model.Address;
import gov.ca.cwds.cm.service.dto.AddressDTO;
import gov.ca.cwds.cm.service.mapper.tool.LegacyBooleanToStringMapper;
import gov.ca.cwds.cm.service.mapper.tool.LegacyZeroNumberToNullStringMapper;
import gov.ca.cwds.cm.service.mapper.tool.ZeroNumberToNullStringField;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS TPT-3 Team
 */

@Mapper(uses = { LegacyBooleanToStringMapper.class, LegacyZeroNumberToNullStringMapper.class })
public interface AddressMapper {

  @Mapping(target = "messages", ignore = true)
  @Mapping(source = "addressDescription", target = "description")
  @Mapping(
      source = "emergencyNumber",
      target = "emergencyPhone",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(
      source = "emergencyExtension",
      target = "emergencyPhoneExtension",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(source = "frgAdrtB", target = "foreignAddressExists")
  @Mapping(source = "governmentEntityCd", target = "governmentEntityCode")
  @Mapping(
      source = "messageNumber",
      target = "messagePhone",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(
      source = "messageExtension",
      target = "messagePhoneExtension",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(source = "headerAddress", target = "otherHeaderAddress")
  @Mapping(source = "postDirCd", target = "postDirectionTextCode")
  @Mapping(source = "preDirCd", target = "preDirectionTextCode")
  @Mapping(
      source = "primaryNumber",
      target = "primaryPhone",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(
      source = "primaryExtension",
      target = "primaryPhoneExtension",
      qualifiedBy = ZeroNumberToNullStringField.class
  )
  @Mapping(source = "stateCd", target = "stateCode")
  @Mapping(source = "streetSuffixCd", target = "streetSuffixCode")
  @Mapping(source = "unitDesignationCd", target = "unitDesignatorCode")
  @Mapping(source = "zip4", target = "zipSuffix", qualifiedBy = ZeroNumberToNullStringField.class)
  AddressDTO toDto(final Address address);

  @InheritInverseConfiguration
  @Mapping(target = "state", ignore = true)
  @Mapping(target = "contextAddressType", ignore = true)
  @Mapping(target = "lastUpdatedId", ignore = true)
  @Mapping(target = "lastUpdatedTime", ignore = true)
  Address toEntity(final AddressDTO dto);

}
