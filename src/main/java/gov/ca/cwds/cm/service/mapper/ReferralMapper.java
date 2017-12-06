package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.data.legacy.cms.entity.Referral;
import org.mapstruct.Mapping;

/**
 * @author CWDS TPT-3 Team
 */
public interface ReferralMapper {

  @Mapping(source = "identifier", target = "id")
  @Mapping(source = "additionalInfoIncludedCode", target = "additionalInfoIncludedCode")
  @Mapping(source = "anonymousReporterIndicator", target = "anonymousReporterIndicator")
  @Mapping(source = "applicationForPetitionIndicator", target = "applicationForPetitionIndicator")
  @Mapping(source = "approvalNumber", target = "approvalNumber")
  @Mapping(source = "approvalStatusType", target = "approvalStatusType")
  @Mapping(source = "caretakersPerpetratorCode", target = "caretakersPerpetratorCode")
  @Mapping(source = "closureDate", target = "closureDate")
  @Mapping(source = "communicationMethodType", target = "communicationMethodType")
  @Mapping(source = "countySpecificCode", target = "id")
  @Mapping(source = "currentLocationOfChildren", target = "id")
  @Mapping(source = "drmsAllegationDescriptionDoc", target = "id")
  @Mapping(source = "drmsErReferralDoc", target = "id")
  @Mapping(source = "drmsInvestigationDoc", target = "id")
  @Mapping(source = "familyAwarenessIndicator", target = "id")
  @Mapping(source = "familyRefusedServicesIndicator", target = "id")
  @Mapping(source = "filedSuspectedChildAbuseReporttoLawEnforcementIndicator", target = "id")
  @Mapping(source = "firstEvaluatedOutApprovalDate", target = "firstEvaluatedOutApprovalDate")
  @Mapping(source = "allegesAbuseOccurredAtAddressId", target = "allegesAbuseOccurredAtAddressId")
  @Mapping(source = "linkToPrimaryReferralId", target = "linkToPrimaryReferralId")
  @Mapping(source = "firstResponseDeterminedByStaffPersonId", target = "firstResponseDeterminedByStaffPersonId")
  @Mapping(source = "primaryContactStaffPersonId", target = "primaryContactStaffPersonId")
  @Mapping(source = "govtEntityType", target = "govtEntityType")
  @Mapping(source = "homelessIndicator", target = "homelessIndicator")
  @Mapping(source = "legalDefinitionCode", target = "legalDefinitionCode")
  @Mapping(source = "legalRightsNoticeIndicator", target = "legalRightsNoticeIndicator")
  @Mapping(source = "limitedAccessCode", target = "limitedAccessCode")
  @Mapping(source = "limitedAccessDate", target = "limitedAccessDate")
  @Mapping(source = "limitedAccessDesc", target = "limitedAccessDesc")
  @Mapping(source = "limitedAccessGovtAgencyType", target = "limitedAccessGovtAgencyType")
  @Mapping(source = "mandatedCrossReportReceivedDate", target = "mandatedCrossReportReceivedDate")
  @Mapping(source = "referralName", target = "referralName")
  @Mapping(source = "openAdequateCaseCode", target = "openAdequateCaseCode")
  @Mapping(source = "originalClosureDate", target = "originalClosureDate")
  @Mapping(source = "receivedDate", target = "receivedDate")
  @Mapping(source = "receivedTime", target = "receivedTime")
  @Mapping(source = "referralResponseType", target = "referralResponseType")
  @Mapping(source = "referredToResourceType", target = "referredToResourceType")
  @Mapping(source = "responseDeterminationDate", target = "responseDeterminationDate")
  @Mapping(source = "responseDeterminationTime", target = "responseDeterminationTime")
  @Mapping(source = "responseRationaleText", target = "responseRationaleText")
  @Mapping(source = "responsibleAgencyCode", target = "responsibleAgencyCode")
  @Mapping(source = "screenerNoteText", target = "screenerNoteText")
  @Mapping(source = "specialProjectReferralIndicator", target = "specialProjectReferralIndicator")
  @Mapping(source = "specificsIncludedCode", target = "specificsIncludedCode")
  @Mapping(source = "sufficientInformationCode", target = "sufficientInformationCode")
  @Mapping(source = "unfoundedSeriesCode", target = "unfoundedSeriesCode")
  @Mapping(source = "zippyCreatedIndicator", target = "zippyCreatedIndicator")
  ReferralDTO toReferralDTO(Referral referral);

}
