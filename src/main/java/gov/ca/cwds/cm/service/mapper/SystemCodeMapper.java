package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.SystemCodeDTO;
import gov.ca.cwds.cm.service.mapper.tool.LegacyBooleanToStringMapper;
import gov.ca.cwds.data.persistence.cms.SystemCode;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author CWDS TPT-3 Team
 */

@Mapper(uses = { LegacyBooleanToStringMapper.class })
public interface SystemCodeMapper {

  @Mapping(source = "foreignKeyMetaTable", target = "metaCode")
  @Mapping(source = "otherCd", target = "otherCode")
  @Mapping(target = "messages", ignore = true)
  SystemCodeDTO toDto(final SystemCode address);

}
