package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(
  imports = {Constants.class},
  uses = {ChildClientMapper.class}
)
public interface CaseMapper {

  CaseMapper INSTANCE = Mappers.getMapper(CaseMapper.class);

  @Mapping(source = "identifier", target = "id")
  @Mapping(source = "approvalStatusType.shortDsc", target = "approvalStatus")
  @Mapping(source = "caseClosureReasonType.shortDsc", target = "caseClosureReason")
  @Mapping(source = "caseplanChildrenDetailIndVar", target = "isCaseplanChildrenDetail")
  @Mapping(source = "icpcOutgngPlcmtStatusIndVar", target = "isIcpcOutgoingPlacementStatus")
  @Mapping(source = "icpcOutgoingRequestIndVar", target = "isIcpcOutgoingRequest")
  @Mapping(source = "specialProjectCaseIndVar", target = "isSpecialProjectCase")
  @Mapping(source = "activeServiceComponentType.shortDsc", target = "activeServiceComponent")
  @Mapping(source = "activeSvcComponentStartDate", target = "activeServiceComponentStartDate")
  @Mapping(source = "tickleIndVar", target = "isTickle")
  @Mapping(source = "country.shortDsc", target = "country")
  @Mapping(source = "county.shortDsc", target = "county")
  @Mapping(source = "limitedAccessCounty.shortDsc", target = "limitedAccessCounty")
  @Mapping(source = "limitedAccess.description", target = "limitedAccess")
  @Mapping(source = "responsibleAgency.description", target = "responsibleAgency")
  @Mapping(source = "state.shortDsc", target = "state")
  // TODO: StaffPersonDTO should be implemented
  @Mapping(source = "staffPerson.identifier", target = "staffPerson")
  CaseDTO toCaseDTO(Case caseEntity);
}
