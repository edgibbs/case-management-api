package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/** @author CWDS TPT-3 Team */
@Mapper
public interface ChildClientMapper {

  ChildClientMapper INSTANCE = Mappers.getMapper(ChildClientMapper.class);

  @Mapping(source = "victimClientId", target = "victimClientId")
  @Mapping(source = "adoptableCode", target = "adoptableCode")
  @Mapping(source = "adoptedAge", target = "adoptedAge")
  @Mapping(source = "afdcFcEligibilityIndicatorVar", target = "afdcFcEligibilityIndicatorVar")
  @Mapping(source = "allEducationInfoOnFileIndicator", target = "allEducationInfoOnFileIndicator")
  @Mapping(source = "allHealthInfoOnFileIndicator", target = "allHealthInfoOnFileIndicator")
  @Mapping(source = "attemptToAcquireEducInfoDesc", target = "attemptToAcquireEducInfoDesc")
  @Mapping(source = "attemptToAcquireHlthInfoDesc", target = "attemptToAcquireHlthInfoDesc")
  @Mapping(source = "awolAbductedCode", target = "awolAbductedCode")
  @Mapping(source = "birthHistoryIndicatorVar", target = "birthHistoryIndicatorVar")
  @Mapping(source = "childIndianAncestryIndicator", target = "childIndianAncestryIndicator")
  @Mapping(source = "collegeIndicator", target = "collegeIndicator")
  @Mapping(source = "currentCaseId", target = "currentCaseId")
  @Mapping(target = "deathCircumstancesType", ignore = true) //target = "deathCircumstancesType")
  @Mapping(source = "disabilityDiagnosedCode", target = "disabilityDiagnosedCode")
  @Mapping(source = "drmsHePassportDocOld", target = "drmsHePassportDocOld")
  @Mapping(source = "foodStampsApplicationIndicator", target = "foodStampsApplicationIndicator")
  @Mapping(source = "icwaEligibilityCode", target = "icwaEligibilityCode")
  @Mapping(
    source = "intercountryAdoptDisruptedIndicator",
    target = "intercountryAdoptDisruptedIndicator"
  )
  @Mapping(
    source = "medEligibilityApplicationIndicatorVar",
    target = "medEligibilityApplicationIndicatorVar"
  )
  @Mapping(source = "minorNmdParentIndicator", target = "minorNmdParentIndicator")
  @Mapping(source = "parentalRightsLimitedIndicator", target = "parentalRightsLimitedIndicator")
  @Mapping(
    source = "parentalRightsTermintnIndicatorVar",
    target = "parentalRightsTermintnIndicatorVar"
  )
  @Mapping(source = "paternityIndividualIndicatorVar", target = "paternityIndividualIndicatorVar")
  @Mapping(source = "postsecVocIndicator", target = "postsecVocIndicator")
  @Mapping(source = "previouslyAdoptedCode", target = "previouslyAdoptedCode")
  @Mapping(
    source = "safelySurrendedBabiesIndicatorVar",
    target = "safelySurrendedBabiesIndicatorVar"
  )
  @Mapping(source = "sawsCaseSerialNumber", target = "sawsCaseSerialNumber")
  @Mapping(target = "sijsScheduledInterviewDate", ignore = true)
  @Mapping(target = "siiNextScreeningDueDate", ignore = true)
  @Mapping(source = "ssiSspApplicationIndicator", target = "ssiSspApplicationIndicator")
  @Mapping(
    source = "tribalAncestryNotifctnIndicatorVar",
    target = "tribalAncestryNotifctnIndicatorVar"
  )
  @Mapping(target = "tribalCustomaryAdoptionDate", ignore = true)
  @Mapping(source = "tribalCustomaryAdoptionIndicator", target = "tribalCustomaryAdoptionIndicator")
  @Mapping(target = "foodStampsApplicationDate", ignore = true)
  ChildClientDTO toChildClientDTO(ChildClient childClient);
}
