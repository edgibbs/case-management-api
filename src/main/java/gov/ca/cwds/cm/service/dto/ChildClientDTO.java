package gov.ca.cwds.cm.service.dto;

import static gov.ca.cwds.data.persistence.cms.CmsPersistentObject.CMS_ID_LEN;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.dropwizard.validation.OneOf;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.NotEmpty;

/** @author CWDS TPT-3 Team */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@SuppressWarnings({"squid:S3437"})
public class ChildClientDTO extends ClientDTO {

  private static final long serialVersionUID = 7569314519640349923L;

  @NotNull
  @ApiModelProperty(
      required = true,
      readOnly = true,
      value = "CLIENT ID of victim",
      example = "ABC1234567"
  )
  private String victimClientId;

  @NotEmpty
  @OneOf(
      value = {"NOT_ADOPTABLE", "NOT_ASSESSED", "ADOPTABLE"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, value = "Adoptable Code", example = "ADOPTABLE")
  private String adoptableCode;

  @NotNull
  @ApiModelProperty(value = "Adpoted Age", example = "34")
  private Short adoptedAge;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean afdcFcEligibilityIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean allEducationInfoOnFileIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean allHealthInfoOnFileIndicator;

  @NotNull
  @Size(max = 254)
  @ApiModelProperty(example = "Education")
  private String attemptToAcquireEducInfoDesc;

  @NotNull
  @Size(max = 254)
  @ApiModelProperty(example = "Health")
  private String attemptToAcquireHlthInfoDesc;

  @NotNull
  @ApiModelProperty(required = true, example = "AWOL_BASED_ON_USER_ENTRY")
  @OneOf(
      value = {
          "AWOL_BASED_ON_USER_ENTRY",
          "ABDUCTED_BASED_ON_USER_ENTRY",
          "ABDUCTED_BASED_ON_SYSTEM_SETTING",
          "NOT_APPLICABLE",
          "AWOL_BASED_ON_SYSTEM_SETTING"
      },
      ignoreCase = true,
      ignoreWhitespace = true
  )
  private String awolAbductedCode;

  @NotNull
  @ApiModelProperty(required = true)
  private boolean birthHistoryIndicatorVar;

  @NotNull @ApiModelProperty private Boolean childIndianAncestryIndicator;

  @ApiModelProperty private Boolean collegeIndicator;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(example = "ABC1234567")
  private String currentCaseId;

  @NotNull
  @ApiModelProperty(example = "1234")
  private String deathCircumstancesType;

  @OneOf(
      value = {"NOT_YET_DETERMINED", "NO", "YES"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(value = "Disablility Diagnosed", example = "NOT_YET_DETERMINED")
  private String disabilityDiagnosedCode;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty()
  private String drmsHePassportDocOld;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(example = "Document")
  private String drmsHealthEducPassportDoc;

  @Size(max = CMS_ID_LEN)
  @ApiModelProperty(example = "Agreement")
  private String drmsVoluntaryPlcmntAgrmntDoc;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean fc2EligApplicationIndicatorVar;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate foodStampsApplicationDate;

  @NotNull
  @ApiModelProperty(required = true, example = "true")
  private Boolean foodStampsApplicationIndicator;

  @NotEmpty
  @OneOf(
      value = {"NOT_ELIGIBLE", "ELIGIBLE", "UNKNOWN", "PENDING"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, example = "PENDING")
  private String icwaEligibilityCode;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean intercountryAdoptDisruptedIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean intercountryAdoptDissolvedIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean medEligibilityApplicationIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean minorNmdParentIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean parentalRightsLimitedIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean parentalRightsTermintnIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean paternityIndividualIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean postsecVocIndicator;

  @NotEmpty
  @OneOf(
      value = {"NO", "UNKNOWN", "NO_USER_SELECTION", "YES"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, example = "NO_USER_SELECTION")
  private String previouslyAdopted;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean safelySurrendedBabiesIndicatorVar;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean saw1EligApplicationIndicatorVar;

  @NotNull
  @ApiModelProperty(example = "0")
  private Integer sawsCaseSerialNumber;

  @ApiModelProperty(value = "yyyy-MM-dd", example = "2000-01-01")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate sijsScheduledInterviewDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  @ApiModelProperty(value = "yyyy-MM-dd", example = "2000-01-01")
  private LocalDate siiNextScreeningDueDate;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean ssiSspApplicationIndicator;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean tribalAncestryNotifctnIndicatorVar;

  @ApiModelProperty(value = "yyyy-MM-dd", example = "2000-01-01")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  private LocalDate tribalCustomaryAdoptionDate;

  @NotNull
  @ApiModelProperty(required = true)
  private Boolean tribalCustomaryAdoptionIndicator;
}
