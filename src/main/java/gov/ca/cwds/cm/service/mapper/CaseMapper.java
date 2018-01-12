package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.cm.service.mapper.tool.LegacyZeroNumberToNullNumberMapper;
import gov.ca.cwds.cm.service.mapper.tool.TrailingSpacesRemovalPostMappingProcessor;
import gov.ca.cwds.cm.service.mapper.tool.ZeroNumberToNullNumberField;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** @author CWDS TPT-3 Team */
@Mapper(uses = {
    TrailingSpacesRemovalPostMappingProcessor.class,
    LegacyZeroNumberToNullNumberMapper.class
})
@FunctionalInterface
public interface CaseMapper {

  @Mapping(target = "messages", ignore = true)
  @Mapping(source = "identifier", target = "id")
  @Mapping(source = "approvalStatusType.systemId", target = "approvalStatusCode")
  @Mapping(
    source = "caseClosureReasonTypeCode",
    target = "caseClosureReasonCode",
    qualifiedBy = ZeroNumberToNullNumberField.class
  )
  @Mapping(source = "activeServiceComponentType.systemId", target = "activeServiceComponentCode")
  @Mapping(source = "activeSvcComponentStartDate", target = "activeServiceComponentStartDate")
  @Mapping(source = "country.systemId", target = "countryCode")
  @Mapping(source = "county.systemId", target = "countyCode")
  @Mapping(source = "countySpecificCode", target = "countySpecificCode")
  @Mapping(source = "limitedAccessCounty.systemId", target = "limitedAccessCountyCode")
  @Mapping(source = "limitedAccess", target = "limitedAccess")
  @Mapping(source = "drmsNotesDoc", target = "drmsNotesDocId")
  @Mapping(source = "responsibleAgency", target = "responsibleAgency")
  @Mapping(
    source = "stateCode",
    target = "stateCode",
    qualifiedBy = ZeroNumberToNullNumberField.class
  )
  @Mapping(source = "staffPerson.identifier", target = "staffPersonId")
  @Mapping(source = "childClient.victimClientId", target = "childClientId")
  @Mapping(source = "alertText.identifier", target = "alertTextId")
  @Mapping(source = "closureStatementText.identifier", target = "closureStatementTextId")
  CaseDTO toCaseDTO(Case caseEntity);
}
