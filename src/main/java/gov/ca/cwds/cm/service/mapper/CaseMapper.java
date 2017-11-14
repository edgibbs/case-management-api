package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  imports = {Constants.class}
)
public interface CaseMapper {

  CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

  @Mapping(target = "messages", ignore = true)
  @Mapping(source = "identifier", target = "id")
  @Mapping(source = "approvalStatusType.shortDsc", target = "approvalStatus")
  @Mapping(source = "caseClosureReasonType.shortDsc", target = "caseClosureReason")
  @Mapping(source = "caseplanChildrenDetailIndVar", target = "caseplanChildrenDetail")
  @Mapping(source = "icpcOutgngPlcmtStatusIndVar", target = "icpcOutgoingPlacementStatus")
  @Mapping(source = "icpcOutgoingRequestIndVar", target = "icpcOutgoingRequest")
  @Mapping(source = "specialProjectCaseIndVar", target = "specialProjectCase")
  @Mapping(source = "activeServiceComponentType.shortDsc", target = "activeServiceComponent")
  @Mapping(source = "activeSvcComponentStartDate", target = "activeServiceComponentStartDate")
  @Mapping(source = "tickleIndVar", target = "tickle")
  @Mapping(source = "country.shortDsc", target = "country")
  @Mapping(source = "county.shortDsc", target = "county")
  @Mapping(source = "limitedAccessCounty.shortDsc", target = "limitedAccessCounty")
  @Mapping(source = "limitedAccess.description", target = "limitedAccess")
  @Mapping(source = "responsibleAgency.description", target = "responsibleAgency")
  @Mapping(source = "state.shortDsc", target = "state")
  @Mapping(source = "staffPerson.identifier", target = "staffPerson")
  @Mapping(source = "childClient.victimClientId", target = "childClient")
  CaseDTO toCaseDTO(Case caseEntity);
}
