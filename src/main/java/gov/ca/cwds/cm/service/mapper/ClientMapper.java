package gov.ca.cwds.cm.service.mapper;

import gov.ca.cwds.cm.service.dto.ClientDTO;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/** @author CWDS TPT-3 Team */
@Mapper
public interface ClientMapper {

  ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

  @Mapping(target = "commentDescription", source = "commntDsc")
  @Mapping(target = "estimatedDobCode", source = "estDobCd")
  @Mapping(target = "birthplaceVerifiedIdentificator", source = "bpVerInd")
  @Mapping(target = "hispanicOriginCode", source = "hispCd")
  @Mapping(target = "healthTxt", source = "healthTxt")
  @Mapping(target = "birthCity", source = "birthCity")
  @Mapping(target = "limitationOnSCPHealthIndicator", source = "limitInd")
  @Mapping(target = "healthCarePlanIdentificator", source = "hcareInd")
  @Mapping(target = "previouslyOtherDescription", source = "pothDesc")
  @Mapping(target = "previouslyRegionalCenterIdentificator", source = "preregInd")
  @Mapping(target = "previouslyReceivedIdentificator", source = "prevcaInd")
  @Mapping(target = "currentlyOtherDescription", source = "cothDesc")
  @Mapping(target = "childrenServIdentificator", source = "currcaInd")
  @Mapping(target = "currentlyRegionalCenteerIdentificator", source = "curregInd")
  @Mapping(target = "adjudicatedDelinquentIdentificator", source = "adjdelInd")
  @Mapping(target = "deathDateVerifiedIdentificator", source = "dthDtInd")
  @Mapping(target = "emailAddr", source = "emailAddr")
  @Mapping(target = "soc158Ind", source = "soc158Ind")
  @Mapping(target = "tribalAncestryClientIdentificator", source = "trbaCltB")
  @Mapping(target = "tribalMemberVerificationIdentificator", source = "trMbvrtB")
  @Mapping(target = "deathPlace", source = "deathPlc")
  @Mapping(target = "zippyIdentificator", source = "zippyInd")
  @Mapping(target = "fatherParentalTermDate", source = "ftermDt")
  @Mapping(target = "sciIndexNumber", source = "clIndxNo")
  @Mapping(target = "motherParentalTermDate", source = "mtermDt")
  @Mapping(target = "soc158PlacementCode", source = "socplcCd")
  @Mapping(target = "hispUnableToDeterminateReasonCode", source = "hispUdCd")
  @Mapping(target = "ethUnableToDeterminCode", source = "ethUdCd")
  @Mapping(target = "lastUpdateTimestamp", source = "lstUpdTs")
  @Mapping(target = "lstUpdateId", source = "lstUpdId")
  @Mapping(target = "unemployedParentCode", source = "unemplyCd")
  @Mapping(target = "suffixTitleDescription", source = "sufxTldsc")
  @Mapping(target = "socialSecurityNumberChangedCode", source = "ssnChgCd")
  @Mapping(target = "socialSecurityNumber", source = "ssNo")
  @Mapping(target = "sensivityHealthInfoOnFileIndicator", source = "sntvHlind")
  @Mapping(target = "sensivityIndicator", source = "senstvInd")
  @Mapping(target = "secondaryLanguageType", source = "sLangTc")
  @Mapping(target = "religionType", source = "rlgnTpc")
  @Mapping(target = "primaryLanguageType", source = "pLangTpc")
  @Mapping(target = "primaryEthnicityType", source = "pEthnctyc")
  @Mapping(target = "outstandingWarrantIndicator", source = "outwrtInd")
  @Mapping(target = "nameType", source = "nameTpc")
  @Mapping(target = "namePrefixDescription", source = "nmprfxDsc")
  @Mapping(target = "militaryStatusCode", source = "miltStacd")
  @Mapping(target = "materialStatusType", source = "mrtlStc")
  @Mapping(target = "maritalCohabitatnIndicator", source = "marHistB")
  @Mapping(target = "litrateCode", source = "litrateCd")
  @Mapping(target = "incapacitatedParentCode", source = "incapcCd")
  @Mapping(target = "immigrationStatusType", source = "imgtStc")
  @Mapping(target = "immigrationCountryCodeType", source = "iCntryC")
  @Mapping(target = "genderCode", source = "genderCd")
  @Mapping(target = "driverLicenseStateCodeType", source = "dStateC")
  @Mapping(target = "driverLicensNumber", source = "drvLicNo")
  @Mapping(target = "deathReason", source = "dthRnTxt")
  @Mapping(target = "deathDate", source = "deathDt")
  @Mapping(target = "creationDate", source = "creatnDt")
  @Mapping(target = "confidentialityActionDate", source = "confActdt")
  @Mapping(target = "confidentialityInEffectInd", source = "confEfind")
  @Mapping(target = "commonMiddleName", source = "comMidNm")
  @Mapping(target = "commonLastName", source = "comLstNm")
  @Mapping(target = "commonFirstName", source = "comFstNm")
  @Mapping(target = "childClientIndVar", source = "chldCltB")
  @Mapping(target = "birthCountryCode", source = "bCntryC")
  @Mapping(target = "birthStateCodeType", source = "bStateC")
  @Mapping(target = "birthFacilityName", source = "brFacNm")
  @Mapping(target = "birthDt", source = "birthDt")
  @Mapping(target = "alienRegistrationNumber", source = "alnRegNo")
  @Mapping(target = "adoptionStatusCode", source = "adptnStcd")
  @Mapping(target = "identifier", source = "identifier")
  ClientDTO toClientDTO(Client client);
}
