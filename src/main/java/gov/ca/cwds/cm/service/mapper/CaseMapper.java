package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  uses = TrailingSpacesRemovalPostMappingProcessor.class
)
public interface CaseMapper {

  CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

  @Mapping(target = "messages", ignore = true)
  @Mapping(source = "identifier", target = "id")
  @Mapping(source = "approvalStatusType.sysId", target = "approvalStatus")
  @Mapping(source = "caseClosureReasonType.sysId", target = "caseClosureReason")
  @Mapping(source = "caseplanChildrenDetailIndVar", target = "caseplanChildrenDetail")
  @Mapping(source = "icpcOutgngPlcmtStatusIndVar", target = "icpcOutgoingPlacementStatus")
  @Mapping(source = "icpcOutgoingRequestIndVar", target = "icpcOutgoingRequest")
  @Mapping(source = "specialProjectCaseIndVar", target = "specialProjectCase")
  @Mapping(source = "activeServiceComponentType.sysId", target = "activeServiceComponent")
  @Mapping(source = "activeSvcComponentStartDate", target = "activeServiceComponentStartDate")
  @Mapping(source = "tickleIndVar", target = "tickle")
  @Mapping(source = "country.sysId", target = "country")
  @Mapping(source = "county.sysId", target = "county")
  @Mapping(source = "limitedAccessCounty.sysId", target = "limitedAccessCounty")
  @Mapping(source = "limitedAccess.description", target = "limitedAccess")
  @Mapping(source = "responsibleAgency.description", target = "responsibleAgency")
  @Mapping(source = "state.sysId", target = "state")
  @Mapping(source = "staffPerson.identifier", target = "staffPerson")
  @Mapping(source = "childClient.victimClientId", target = "childClient")
  @Mapping(source = "alertText.identifier", target = "alertText")
  @Mapping(source = "closureStatementText.identifier", target = "closureStatementText")
  CaseDTO toCaseDTO(Case caseEntity);
}
