package gov.ca.cwds.cm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.RequestResponse;
import io.dropwizard.validation.OneOf;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Objects;

import static gov.ca.cwds.data.persistence.cms.CmsPersistentObject.CMS_ID_LEN;

/** @author CWDS TPT-3 Team */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@SuppressWarnings({"squid:S3437"})
public class ChildClientDTO extends BaseDTO implements RequestResponse {

  private static final long serialVersionUID = 7569314519640349923L;

  @NotNull
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(
    required = true,
    readOnly = true,
    value = "CLIENT ID of victim",
    example = "ABC1234567"
  )
  private String victimClientId;

  @NotEmpty
  @Size(min = 1, max = 2)
  @OneOf(
    value = {"N", "Y", "NA"},
    ignoreCase = true,
    ignoreWhitespace = true
  )
  @ApiModelProperty(
    required = true,
    readOnly = false,
    value = "Adoptable Code",
    example = "ADOPTABLE"
  )
  private String adoptableCode;

  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "Adpoted Age", example = "34")
  private Short adoptedAge;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean afdcFcEligibilityIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean allEducationInfoOnFileIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean allHealthInfoOnFileIndicator;

  @NotNull
  @Size(max = 254)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "Eucation")
  private String attemptToAcquireEducInfoDesc;

  @NotNull
  @Size(max = 254)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "Health")
  private String attemptToAcquireHlthInfoDesc;

  @NotNull
  @Size(max = 1, message = "size must be 1")
  @ApiModelProperty(required = true, readOnly = false, value = "", example = "N")
  private String awolAbductedCode;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean birthHistoryIndicatorVar;

  @NotNull
  @ApiModelProperty(required = false, readOnly = false)
  private Boolean childIndianAncestryIndicator;

  @ApiModelProperty(required = false, readOnly = false)
  private Boolean collegeIndicator;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "ABC1234567")
  private String currentCaseId;

  @NotNull
  @ApiModelProperty(required = false, readOnly = false, example = "1234")
  private String deathCircumstancesType;

  @Size(min = 1, max = 1)
  @OneOf(
    value = {"N", "Y", "D"},
    ignoreCase = true,
    ignoreWhitespace = true
  )
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "Disablility Diagnosed",
    example = "N"
  )
  private String disabilityDiagnosedCode;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "")
  private String drmsHePassportDocOld;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "Document")
  private String drmsHealthEducPassportDoc;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "Agreement")
  private String drmsVoluntaryPlcmntAgrmntDoc;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean fc2EligApplicationIndicatorVar;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @gov.ca.cwds.rest.validation.Date(format = "yyyy-MM-dd", required = false)
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  private LocalDateTime foodStampsApplicationDate;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false, example = "true")
  private Boolean foodStampsApplicationIndicator;

  @NotEmpty
  @Size(min = 1, max = 1, message = "size must be 1")
  @OneOf(
    value = {"Y", "N", "U", "P"},
    ignoreCase = true,
    ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, readOnly = false, value = "", example = "N")
  private String icwaEligibilityCode;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean intercountryAdoptDisruptedIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean intercountryAdoptDissolvedIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean medEligibilityApplicationIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean minorNmdParentIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean parentalRightsLimitedIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean parentalRightsTermintnIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean paternityIndividualIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean postsecVocIndicator;

  @NotEmpty
  @Size(min = 1, max = 1, message = "size must be 1")
  @OneOf(
    value = {"Y", "N", "U", "X"},
    ignoreCase = true,
    ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, readOnly = false, value = "", example = "N")
  private String previouslyAdopted;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean safelySurrendedBabiesIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean saw1EligApplicationIndicatorVar;

  @NotNull
  @ApiModelProperty(required = false, readOnly = false, value = "", example = "0")
  private Integer sawsCaseSerialNumber;

  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDateTime sijsScheduledInterviewDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  @gov.ca.cwds.rest.validation.Date(format = "yyyy-MM-dd", required = false)
  private LocalDateTime siiNextScreeningDueDate;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean ssiSspApplicationIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean tribalAncestryNotifctnIndicatorVar;

  @ApiModelProperty(
    required = false,
    readOnly = false,
    value = "yyyy-MM-dd",
    example = "2000-01-01"
  )
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDateTime tribalCustomaryAdoptionDate;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private Boolean tribalCustomaryAdoptionIndicator;

  @NotNull
  @ApiModelProperty(required = true, readOnly = false)
  private ClientDTO client;

  public ClientDTO getClient() {
    return client;
  }

  public void setClient(ClientDTO client) {
    this.client = client;
  }

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

  public String getPreviouslyAdopted() {
    return previouslyAdopted;
  }

  public void setPreviouslyAdopted(String previouslyAdopted) {
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

  @Override
  public boolean equals(Object o) {
    return EqualsBuilder.reflectionEquals(this, o);
  }

  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
}
