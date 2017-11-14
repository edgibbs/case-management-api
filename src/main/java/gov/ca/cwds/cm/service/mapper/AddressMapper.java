package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.persistence.model.Address;
import gov.ca.cwds.cm.service.dto.AddressDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS TPT-3 Team
 */

@Mapper(uses = LegacyBooleanToStringMapper.class)
public interface AddressMapper {

  @Mapping(source = "addressDescription", target = "description")
  @Mapping(source = "emergencyNumber", target = "emergencyPhone")
  @Mapping(source = "emergencyExtension", target = "emergencyPhoneExtension")
  @Mapping(source = "frgAdrtB", target = "foreignAddressExists")
  @Mapping(source = "governmentEntityCd", target = "governmentEntityCode")
  @Mapping(source = "messageNumber", target = "messagePhone")
  @Mapping(source = "messageExtension", target = "messagePhoneExtension")
  @Mapping(source = "headerAddress", target = "otherHeaderAddress")
  @Mapping(source = "postDirCd", target = "postDirectionTextCode")
  @Mapping(source = "preDirCd", target = "preDirectionTextCode")
  @Mapping(source = "primaryNumber", target = "primaryPhone")
  @Mapping(source = "primaryExtension", target = "primaryPhoneExtension")
  @Mapping(source = "stateCd", target = "stateCode")
  @Mapping(source = "streetSuffixCd", target = "streetSuffixCode")
  @Mapping(source = "unitDesignationCd", target = "unitDesignatorCode")
  @Mapping(source = "zip4", target = "zipSuffix")
  AddressDTO toDto(final Address address);

  @InheritInverseConfiguration
  Address toEntity(final AddressDTO dto);

}
