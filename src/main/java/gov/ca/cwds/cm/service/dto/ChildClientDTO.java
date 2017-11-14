package gov.ca.cwds.cm.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.RequestResponse;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/** @author CWDS TPT-3 Team */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ChildClientDTO extends BaseDTO implements RequestResponse {

  private static final long serialVersionUID = 7569314519640349923L;

  @JsonProperty("victim_client_id")
  private String victimClientId;

  @JsonProperty("adoptable_code")
  private String adoptableCode;

  @JsonProperty("adopted_age")
  private Short adoptedAge;

  @JsonProperty("afdc_fc_eligibility_indicator_var")
  private Boolean afdcFcEligibilityIndicatorVar;

  @JsonProperty("all_education_info_on_file_indicator")
  private Boolean allEducationInfoOnFileIndicator;

  @JsonProperty("all_health_info_on_file_indicator")
  private Boolean allHealthInfoOnFileIndicator;

  @JsonProperty("attempt_to_acquire_educ_info_desc")
  private String attemptToAcquireEducInfoDesc;

  @JsonProperty("attempt_to_acquire_hlth_info_desc")
  private String attemptToAcquireHlthInfoDesc;

  @JsonProperty("awol_abducted_code")
  private String awolAbductedCode;

  @JsonProperty("birth_history_indicator_var")
  private Boolean birthHistoryIndicatorVar;

  @JsonProperty("child_indian_ancestry_indicator")
  private Boolean childIndianAncestryIndicator;

  @JsonProperty("college_indicator")
  private Boolean collegeIndicator;

  @JsonProperty("current_case_id")
  private String currentCaseId;

  @JsonProperty("death_circumstances_type")
  private String deathCircumstancesType;

  @JsonProperty("disability_diagnosed_code")
  private String disabilityDiagnosedCode;

  @JsonProperty("drms_he_passport_doc_old")
  private String drmsHePassportDocOld;

  @JsonProperty("drms_health_educ_passport_doc")
  private String drmsHealthEducPassportDoc;

  @JsonProperty("drms_voluntary_plcmnt_agrmnt_doc")
  private String drmsVoluntaryPlcmntAgrmntDoc;

  @JsonProperty("fc2_elig_application_indicator_var")
  private Boolean fc2EligApplicationIndicatorVar;

  @JsonProperty("food_stamps_application_date")
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  private LocalDateTime foodStampsApplicationDate;

  @JsonProperty("food_stamps_application_indicator")
  private Boolean foodStampsApplicationIndicator;

  @JsonProperty("icwa_eligibility_code")
  private String icwaEligibilityCode;

  @JsonProperty("intercountry_adopt_disrupted_indicator")
  private Boolean intercountryAdoptDisruptedIndicator;

  @JsonProperty("intercountry_adopt_dissolved_indicator")
  private Boolean intercountryAdoptDissolvedIndicator;

  @JsonProperty("med_eligibility_application_indicator_var")
  private Boolean medEligibilityApplicationIndicatorVar;

  @JsonProperty("minor_nmd_parent_indicator")
  private Boolean minorNmdParentIndicator;

  @JsonProperty("parental_rights_limited_indicator")
  private Boolean parentalRightsLimitedIndicator;

  @JsonProperty("parental_rights_termintn_indicator_var")
  private Boolean parentalRightsTermintnIndicatorVar;

  @JsonProperty("paternity_individual_indicator_var")
  private Boolean paternityIndividualIndicatorVar;

  @JsonProperty("postsec_voc_indicator")
  private Boolean postsecVocIndicator;

  @JsonProperty("previously_adopted_code")
  private Boolean previouslyAdopted;

  @JsonProperty("safely_surrended_babies_indicator_var")
  private Boolean safelySurrendedBabiesIndicatorVar;

  @JsonProperty("saw1_elig_application_indicator_var")
  private Boolean saw1EligApplicationIndicatorVar;

  @JsonProperty("saws_case_serial_number")
  private Integer sawsCaseSerialNumber;

  @JsonProperty("sijs_scheduled_interview_date")
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  private LocalDateTime sijsScheduledInterviewDate;

  @JsonProperty("sii_next_screening_due_date")
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  private LocalDateTime siiNextScreeningDueDate;

  @JsonProperty("ssi_ssp_application_indicator")
  private Boolean ssiSspApplicationIndicator;

  @JsonProperty("tribal_ancestry_notifctn_indicator_var")
  private Boolean tribalAncestryNotifctnIndicatorVar;

  @JsonProperty("tribal_customary_adoption_date")
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  private LocalDateTime tribalCustomaryAdoptionDate;

  @JsonProperty("tribal_customary_adoption_indicator")
  private Boolean tribalCustomaryAdoptionIndicator;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getVictimClientId() {
    return victimClientId;
  }

  public void setVictimClientId(String victimClientId) {
    this.victimClientId = victimClientId;
  }

  public String getAdoptableCode() {
    return adoptableCode;
  }

  public void setAdoptableCode(String adoptableCode) {
    this.adoptableCode = adoptableCode;
  }

  public Short getAdoptedAge() {
    return adoptedAge;
  }

  public void setAdoptedAge(Short adoptedAge) {
    this.adoptedAge = adoptedAge;
  }

  public Boolean getAfdcFcEligibilityIndicatorVar() {
    return afdcFcEligibilityIndicatorVar;
  }

  public void setAfdcFcEligibilityIndicatorVar(Boolean afdcFcEligibilityIndicatorVar) {
    this.afdcFcEligibilityIndicatorVar = afdcFcEligibilityIndicatorVar;
  }

  public Boolean getAllEducationInfoOnFileIndicator() {
    return allEducationInfoOnFileIndicator;
  }

  public void setAllEducationInfoOnFileIndicator(Boolean allEducationInfoOnFileIndicator) {
    this.allEducationInfoOnFileIndicator = allEducationInfoOnFileIndicator;
  }

  public Boolean getAllHealthInfoOnFileIndicator() {
    return allHealthInfoOnFileIndicator;
  }

  public void setAllHealthInfoOnFileIndicator(Boolean allHealthInfoOnFileIndicator) {
    this.allHealthInfoOnFileIndicator = allHealthInfoOnFileIndicator;
  }

  public String getAttemptToAcquireEducInfoDesc() {
    return attemptToAcquireEducInfoDesc;
  }

  public void setAttemptToAcquireEducInfoDesc(String attemptToAcquireEducInfoDesc) {
    this.attemptToAcquireEducInfoDesc = attemptToAcquireEducInfoDesc;
  }

  public String getAttemptToAcquireHlthInfoDesc() {
    return attemptToAcquireHlthInfoDesc;
  }

  public void setAttemptToAcquireHlthInfoDesc(String attemptToAcquireHlthInfoDesc) {
    this.attemptToAcquireHlthInfoDesc = attemptToAcquireHlthInfoDesc;
  }

  public String getAwolAbductedCode() {
    return awolAbductedCode;
  }

  public void setAwolAbductedCode(String awolAbductedCode) {
    this.awolAbductedCode = awolAbductedCode;
  }

  public Boolean getBirthHistoryIndicatorVar() {
    return birthHistoryIndicatorVar;
  }

  public void setBirthHistoryIndicatorVar(Boolean birthHistoryIndicatorVar) {
    this.birthHistoryIndicatorVar = birthHistoryIndicatorVar;
  }

  public Boolean getChildIndianAncestryIndicator() {
    return childIndianAncestryIndicator;
  }

  public void setChildIndianAncestryIndicator(Boolean childIndianAncestryIndicator) {
    this.childIndianAncestryIndicator = childIndianAncestryIndicator;
  }

  public Boolean getCollegeIndicator() {
    return collegeIndicator;
  }

  public void setCollegeIndicator(Boolean collegeIndicator) {
    this.collegeIndicator = collegeIndicator;
  }

  public String getCurrentCaseId() {
    return currentCaseId;
  }

  public void setCurrentCaseId(String currentCaseId) {
    this.currentCaseId = currentCaseId;
  }

  public String getDeathCircumstancesType() {
    return deathCircumstancesType;
  }

  public void setDeathCircumstancesType(String deathCircumstancesType) {
    this.deathCircumstancesType = deathCircumstancesType;
  }

  public String getDisabilityDiagnosedCode() {
    return disabilityDiagnosedCode;
  }

  public void setDisabilityDiagnosedCode(String disabilityDiagnosedCode) {
    this.disabilityDiagnosedCode = disabilityDiagnosedCode;
  }

  public String getDrmsHePassportDocOld() {
    return drmsHePassportDocOld;
  }

  public void setDrmsHePassportDocOld(String drmsHePassportDocOld) {
    this.drmsHePassportDocOld = drmsHePassportDocOld;
  }

  public String getDrmsHealthEducPassportDoc() {
    return drmsHealthEducPassportDoc;
  }

  public void setDrmsHealthEducPassportDoc(String drmsHealthEducPassportDoc) {
    this.drmsHealthEducPassportDoc = drmsHealthEducPassportDoc;
  }

  public String getDrmsVoluntaryPlcmntAgrmntDoc() {
    return drmsVoluntaryPlcmntAgrmntDoc;
  }

  public void setDrmsVoluntaryPlcmntAgrmntDoc(String drmsVoluntaryPlcmntAgrmntDoc) {
    this.drmsVoluntaryPlcmntAgrmntDoc = drmsVoluntaryPlcmntAgrmntDoc;
  }

  public Boolean getFc2EligApplicationIndicatorVar() {
    return fc2EligApplicationIndicatorVar;
  }

  public void setFc2EligApplicationIndicatorVar(Boolean fc2EligApplicationIndicatorVar) {
    this.fc2EligApplicationIndicatorVar = fc2EligApplicationIndicatorVar;
  }

  public LocalDateTime getFoodStampsApplicationDate() {
    return foodStampsApplicationDate;
  }

  public void setFoodStampsApplicationDate(LocalDateTime foodStampsApplicationDate) {
    this.foodStampsApplicationDate = foodStampsApplicationDate;
  }

  public Boolean getFoodStampsApplicationIndicator() {
    return foodStampsApplicationIndicator;
  }

  public void setFoodStampsApplicationIndicator(Boolean foodStampsApplicationIndicator) {
    this.foodStampsApplicationIndicator = foodStampsApplicationIndicator;
  }

  public String getIcwaEligibilityCode() {
    return icwaEligibilityCode;
  }

  public void setIcwaEligibilityCode(String icwaEligibilityCode) {
    this.icwaEligibilityCode = icwaEligibilityCode;
  }

  public Boolean getIntercountryAdoptDisruptedIndicator() {
    return intercountryAdoptDisruptedIndicator;
  }

  public void setIntercountryAdoptDisruptedIndicator(Boolean intercountryAdoptDisruptedIndicator) {
    this.intercountryAdoptDisruptedIndicator = intercountryAdoptDisruptedIndicator;
  }

  public Boolean getIntercountryAdoptDissolvedIndicator() {
    return intercountryAdoptDissolvedIndicator;
  }

  public void setIntercountryAdoptDissolvedIndicator(Boolean intercountryAdoptDissolvedIndicator) {
    this.intercountryAdoptDissolvedIndicator = intercountryAdoptDissolvedIndicator;
  }

  public Boolean getMedEligibilityApplicationIndicatorVar() {
    return medEligibilityApplicationIndicatorVar;
  }

  public void setMedEligibilityApplicationIndicatorVar(
      Boolean medEligibilityApplicationIndicatorVar) {
    this.medEligibilityApplicationIndicatorVar = medEligibilityApplicationIndicatorVar;
  }

  public Boolean getMinorNmdParentIndicator() {
    return minorNmdParentIndicator;
  }

  public void setMinorNmdParentIndicator(Boolean minorNmdParentIndicator) {
    this.minorNmdParentIndicator = minorNmdParentIndicator;
  }

  public Boolean getParentalRightsLimitedIndicator() {
    return parentalRightsLimitedIndicator;
  }

  public void setParentalRightsLimitedIndicator(Boolean parentalRightsLimitedIndicator) {
    this.parentalRightsLimitedIndicator = parentalRightsLimitedIndicator;
  }

  public Boolean getParentalRightsTermintnIndicatorVar() {
    return parentalRightsTermintnIndicatorVar;
  }

  public void setParentalRightsTermintnIndicatorVar(Boolean parentalRightsTermintnIndicatorVar) {
    this.parentalRightsTermintnIndicatorVar = parentalRightsTermintnIndicatorVar;
  }

  public Boolean getPaternityIndividualIndicatorVar() {
    return paternityIndividualIndicatorVar;
  }

  public void setPaternityIndividualIndicatorVar(Boolean paternityIndividualIndicatorVar) {
    this.paternityIndividualIndicatorVar = paternityIndividualIndicatorVar;
  }

  public Boolean getPostsecVocIndicator() {
    return postsecVocIndicator;
  }

  public void setPostsecVocIndicator(Boolean postsecVocIndicator) {
    this.postsecVocIndicator = postsecVocIndicator;
  }

  public Boolean getPreviouslyAdopted() {
    return previouslyAdopted;
  }

  public void setPreviouslyAdopted(Boolean previouslyAdopted) {
    this.previouslyAdopted = previouslyAdopted;
  }

  public Boolean getSafelySurrendedBabiesIndicatorVar() {
    return safelySurrendedBabiesIndicatorVar;
  }

  public void setSafelySurrendedBabiesIndicatorVar(Boolean safelySurrendedBabiesIndicatorVar) {
    this.safelySurrendedBabiesIndicatorVar = safelySurrendedBabiesIndicatorVar;
  }

  public Boolean getSaw1EligApplicationIndicatorVar() {
    return saw1EligApplicationIndicatorVar;
  }

  public void setSaw1EligApplicationIndicatorVar(Boolean saw1EligApplicationIndicatorVar) {
    this.saw1EligApplicationIndicatorVar = saw1EligApplicationIndicatorVar;
  }

  public Integer getSawsCaseSerialNumber() {
    return sawsCaseSerialNumber;
  }

  public void setSawsCaseSerialNumber(Integer sawsCaseSerialNumber) {
    this.sawsCaseSerialNumber = sawsCaseSerialNumber;
  }

  public LocalDateTime getSijsScheduledInterviewDate() {
    return sijsScheduledInterviewDate;
  }

  public void setSijsScheduledInterviewDate(LocalDateTime sijsScheduledInterviewDate) {
    this.sijsScheduledInterviewDate = sijsScheduledInterviewDate;
  }

  public LocalDateTime getSiiNextScreeningDueDate() {
    return siiNextScreeningDueDate;
  }

  public void setSiiNextScreeningDueDate(LocalDateTime siiNextScreeningDueDate) {
    this.siiNextScreeningDueDate = siiNextScreeningDueDate;
  }

  public Boolean getSsiSspApplicationIndicator() {
    return ssiSspApplicationIndicator;
  }

  public void setSsiSspApplicationIndicator(Boolean ssiSspApplicationIndicator) {
    this.ssiSspApplicationIndicator = ssiSspApplicationIndicator;
  }

  public Boolean getTribalAncestryNotifctnIndicatorVar() {
    return tribalAncestryNotifctnIndicatorVar;
  }

  public void setTribalAncestryNotifctnIndicatorVar(Boolean tribalAncestryNotifctnIndicatorVar) {
    this.tribalAncestryNotifctnIndicatorVar = tribalAncestryNotifctnIndicatorVar;
  }

  public LocalDateTime getTribalCustomaryAdoptionDate() {
    return tribalCustomaryAdoptionDate;
  }

  public void setTribalCustomaryAdoptionDate(LocalDateTime tribalCustomaryAdoptionDate) {
    this.tribalCustomaryAdoptionDate = tribalCustomaryAdoptionDate;
  }

  public Boolean getTribalCustomaryAdoptionIndicator() {
    return tribalCustomaryAdoptionIndicator;
  }

  public void setTribalCustomaryAdoptionIndicator(Boolean tribalCustomaryAdoptionIndicator) {
    this.tribalCustomaryAdoptionIndicator = tribalCustomaryAdoptionIndicator;
  }
}
