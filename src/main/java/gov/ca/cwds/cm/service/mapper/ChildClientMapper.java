package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingInheritanceStrategy;

/** @author CWDS TPT-3 Team */
@Mapper(config = ClientMapper.class)
@MapperConfig(mappingInheritanceStrategy = MappingInheritanceStrategy.AUTO_INHERIT_FROM_CONFIG)
public interface ChildClientMapper {

  @Mapping(target = "messages", ignore = true)
  @Mapping(target = "victimClientId", source = "victimClientId")
  @Mapping(target = "adoptableCode", source = "adoptable.code")
  @Mapping(target = "adoptedAge", source = "adoptedAge")
  @Mapping(target = "afdcFcEligibilityIndicatorVar", source = "afdcFcEligibilityIndicatorVar")
  @Mapping(target = "allEducationInfoOnFileIndicator", source = "allEducationInfoOnFileIndicator")
  @Mapping(target = "allHealthInfoOnFileIndicator", source = "allHealthInfoOnFileIndicator")
  @Mapping(target = "attemptToAcquireEducInfoDesc", source = "attemptToAcquireEducInfoDesc")
  @Mapping(target = "attemptToAcquireHlthInfoDesc", source = "attemptToAcquireHlthInfoDesc")
  @Mapping(target = "awolAbductedCode", source = "awolAbducted")
  @Mapping(target = "birthHistoryIndicatorVar", source = "birthHistoryIndicatorVar")
  @Mapping(target = "childIndianAncestryIndicator", source = "childIndianAncestryIndicator")
  @Mapping(target = "collegeIndicator", source = "collegeIndicator")
  @Mapping(target = "currentCaseId", source = "currentCaseId")
  @Mapping(target = "disabilityDiagnosedCode", source = "disabilityDiagnosed")
  @Mapping(target = "drmsHePassportDocOld", source = "drmsHePassportDocOld")
  @Mapping(target = "foodStampsApplicationIndicator", source = "foodStampsApplicationIndicator")
  @Mapping(target = "icwaEligibilityCode", source = "icwaEligibility")
  @Mapping(
    target = "intercountryAdoptDisruptedIndicator",
    source = "intercountryAdoptDisruptedIndicator"
  )
  @Mapping(
    target = "medEligibilityApplicationIndicatorVar",
    source = "medEligibilityApplicationIndicatorVar"
  )
  @Mapping(target = "minorNmdParentIndicator", source = "minorNmdParentIndicator")
  @Mapping(target = "parentalRightsLimitedIndicator", source = "parentalRightsLimitedIndicator")
  @Mapping(
    target = "parentalRightsTermintnIndicatorVar",
    source = "parentalRightsTermintnIndicatorVar"
  )
  @Mapping(target = "paternityIndividualIndicatorVar", source = "paternityIndividualIndicatorVar")
  @Mapping(target = "postsecVocIndicator", source = "postsecVocIndicator")
  @Mapping(target = "previouslyAdopted", source = "previouslyAdopted")
  @Mapping(
    target = "safelySurrendedBabiesIndicatorVar",
    source = "safelySurrendedBabiesIndicatorVar"
  )
  @Mapping(target = "sawsCaseSerialNumber", source = "sawsCaseSerialNumber")
  @Mapping(target = "deathCircumstancesType", source = "deathCircumstancesTypeCode")
  @Mapping(target = "sijsScheduledInterviewDate", ignore = true)
  @Mapping(target = "siiNextScreeningDueDate", ignore = true)
  @Mapping(target = "ssiSspApplicationIndicator", source = "ssiSspApplicationIndicator")
  @Mapping(
    target = "tribalAncestryNotifctnIndicatorVar",
    source = "tribalAncestryNotifctnIndicatorVar"
  )
  @Mapping(target = "tribalCustomaryAdoptionDate", ignore = true)
  @Mapping(target = "tribalCustomaryAdoptionIndicator", source = "tribalCustomaryAdoptionIndicator")
  @Mapping(target = "foodStampsApplicationDate", ignore = true)
  ChildClientDTO toChildClientDTO(ChildClient childClient);

  @Mapping(source = "victimClientId", target = "victimClientId")

  @Mapping(source = "adoptedAge", target = "adoptedAge")
  @Mapping(source = "afdcFcEligibilityIndicatorVar", target = "afdcFcEligibilityIndicatorVar")
  @Mapping(source = "allEducationInfoOnFileIndicator", target = "allEducationInfoOnFileIndicator")
  @Mapping(source = "allHealthInfoOnFileIndicator", target = "allHealthInfoOnFileIndicator")
  @Mapping(source = "attemptToAcquireEducInfoDesc", target = "attemptToAcquireEducInfoDesc")
  @Mapping(source = "attemptToAcquireHlthInfoDesc", target = "attemptToAcquireHlthInfoDesc")
  @Mapping(source = "awolAbductedCode", target = "awolAbducted")
  @Mapping(source = "birthHistoryIndicatorVar", target = "birthHistoryIndicatorVar")
  @Mapping(source = "childIndianAncestryIndicator", target = "childIndianAncestryIndicator")
  @Mapping(source = "collegeIndicator", target = "collegeIndicator")
  @Mapping(source = "currentCaseId", target = "currentCaseId")
  @Mapping(source = "disabilityDiagnosedCode", target = "disabilityDiagnosed")
  @Mapping(source = "drmsHePassportDocOld", target = "drmsHePassportDocOld")
  @Mapping(source = "foodStampsApplicationIndicator", target = "foodStampsApplicationIndicator")
  @Mapping(source = "icwaEligibilityCode", target = "icwaEligibility")
  @Mapping(
    target = "intercountryAdoptDisruptedIndicator",
    source = "intercountryAdoptDisruptedIndicator"
  )
  @Mapping(
    target = "medEligibilityApplicationIndicatorVar",
    source = "medEligibilityApplicationIndicatorVar"
  )
  @Mapping(source = "minorNmdParentIndicator", target = "minorNmdParentIndicator")
  @Mapping(source = "parentalRightsLimitedIndicator", target = "parentalRightsLimitedIndicator")
  @Mapping(
    target = "parentalRightsTermintnIndicatorVar",
    source = "parentalRightsTermintnIndicatorVar"
  )
  @Mapping(source = "paternityIndividualIndicatorVar", target = "paternityIndividualIndicatorVar")
  @Mapping(source = "postsecVocIndicator", target = "postsecVocIndicator")
  @Mapping(source = "previouslyAdopted", target = "previouslyAdopted")
  @Mapping(
    target = "safelySurrendedBabiesIndicatorVar",
    source = "safelySurrendedBabiesIndicatorVar"
  )
  @Mapping(source = "sawsCaseSerialNumber", target = "sawsCaseSerialNumber")
  @Mapping(source = "deathCircumstancesType", target = "deathCircumstancesTypeCode")
  @Mapping(source = "ssiSspApplicationIndicator", target = "ssiSspApplicationIndicator")
  @Mapping(
    target = "tribalAncestryNotifctnIndicatorVar",
    source = "tribalAncestryNotifctnIndicatorVar"
  )
  @Mapping(source = "tribalCustomaryAdoptionIndicator", target = "tribalCustomaryAdoptionIndicator")
//  @Mapping(
//      expression = "java(Adoptable.from(clientDTO.getAdoptableCode()))",
//      target = "adoptable"
//  )
  @Mapping(target = "foodStampsApplicationDate", ignore = true)
  @Mapping(target = "adoptable", ignore = true)
  @Mapping(target = "sijsScheduledInterviewDate", ignore = true)
  @Mapping(target = "siiNextScreeningDueDate", ignore = true)
  @Mapping(target = "tribalCustomaryAdoptionDate", ignore = true)
  @Mapping(target = "maritalStatusCode", ignore = true)
  ChildClient fromChildClientDTO(ChildClientDTO clientDTO);
}
