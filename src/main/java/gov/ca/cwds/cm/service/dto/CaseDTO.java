package gov.ca.cwds.cm.service.dto;

import static gov.ca.cwds.data.persistence.cms.CmsPersistentObject.CMS_ID_LEN;
import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.RequestResponse;
import gov.ca.cwds.cm.service.mapper.tool.RemoveTrailingSpaces;
import io.dropwizard.validation.OneOf;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CWDS TPT-3 Team
 */

@Data
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings({"squid:S3437"})
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CaseDTO extends BaseDTO implements RequestResponse {

  private static final long serialVersionUID = -8382919588078449541L;

  //IDENTIFIER, may be null (value is taken from URL)
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "ID", example = "AadfKnG07n")
  private String id;

  //ALERT_TXT
  @RemoveTrailingSpaces
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "Alert Text ID", example = "EssaJ4W0Js")
  private String alertTextId;

  //APV_STC
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Approval Status Code", example = "118")
  private Short approvalStatusCode;

  //CASE_NM
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Case name", example = "Sibling Hanson")
  private String caseName;

  //CL_STM_TXT
  @RemoveTrailingSpaces
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "Case closure statement text ID", example = "Fn3lUdY00F")
  private String closureStatementTextId;

  //CLS_RSNC, if 0 in DB, should be null in DTO
  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Case Closure Reason Code", example = "306")
  private Short caseClosureReasonCode;

  //CNTRY_C
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Country Code", example = "563")
  private Short countryCode;

  //CNTY_SPFCD
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "County Code", example = "10")
  private String countySpecificCode;

  //EMANCPN_DT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(
      value = "The anticipated date the child client will become emancipated",
      example = "2018-10-20"
  )
  private LocalDate emancipationDate;

  //END_DT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(value = "End date", example = "2018-10-20")
  private LocalDate endDate;

  //FKCHLD_CLT
  @RemoveTrailingSpaces
  @NotNull
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(required = true, value = "Child Client ID", example = "8m7hS7i07n")
  private String childClientId;

  //FKREFERL_T
  @RemoveTrailingSpaces
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "Referral ID", example="7Rgxy9S00T")
  private String referralId;

  //FKSTFPERST
  @RemoveTrailingSpaces
  @NotNull
  @Size(min = 3, max = 3)
  @ApiModelProperty(required = true, value = "Staff Person ID", example="07n")
  private String staffPersonId;

  //GVR_ENTC
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(
      required = true,
      value = "Code of the county within the state of California to which a specific CASE is assigned",
      example = "1068"
  )
  private Short countyCode;

  //L_GVR_ENTC
  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Limited access county", example = "1068")
  private Short limitedAccessCountyCode;

  //LMT_ACS_DT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(value = "Limited access date", example = "2016-10-25")
  private LocalDate limitedAccessDate;

  //LMT_ACSDSC
  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Limited access description", example = "Text")
  private String limitedAccessDesc;

  //LMT_ACSSCD
  @RemoveTrailingSpaces
  @NotNull
  @OneOf(
      value = {
          "NO_RESTRICTION",
          "SEALED",
          "SENSITIVE"
      },
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, value = "Security access level code", example = "SEALED")
  private String limitedAccess;

  //NOTES_DOC
  @RemoveTrailingSpaces
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "DRMS notes document ID", example = "At9HoSn0WJ")
  private String drmsNotesDocId;

  //NXT_TILPDT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(
      value = "Next Transitional Independent Living Plan due date",
      example = "2018-10-24"
  )
  private LocalDate nextTilpDueDate;

  //PRJ_END_DT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(
      value = "Next Transitional Independent Living Plan due date",
      example = "2018-10-23"
  )
  private LocalDate projectedEndDate;

  //RSP_AGY_CD
  @RemoveTrailingSpaces
  @OneOf(
      value = {
          "PRIVATE_ADOPTION_AGENCY",
          "COUNTY_WELFARE_DEPARTMENT",
          "INDIAN_CHILD_WELFARE",
          "KIN_GAP",
          "MENTAL_HEALTH",
          "OUT_OF_STATE_AGENCY",
          "PROBATION",
          "STATE_ADOPTION_DISTRICT_OFFICE"
      },
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(value = "Responsible agency code", example = "PRIVATE_ADOPTION_AGENCY")
  private String responsibleAgency;

  //SRV_CMPC
  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(
      required = true,
      value = "Code of the service component being referenced for a child's case",
      example = "1692"
  )
  private Short activeServiceComponentCode;

  //SRV_CMPDT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @NotNull
  @ApiModelProperty(required = true, value = "Service component start date", example = "2016-10-23")
  private LocalDate activeServiceComponentStartDate;

  //START_DT
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @NotNull
  @ApiModelProperty(required = true, value = "Start date", example = "2016-10-23")
  private LocalDate startDate;

  //STATE_C, if 0 in DB, should be null in DTO
  @RemoveTrailingSpaces
  @ApiModelProperty(value = "State", example = "1828")
  private Short stateCode;
}
