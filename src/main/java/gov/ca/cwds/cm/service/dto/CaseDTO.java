package gov.ca.cwds.cm.service.dto;

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

  private static final long serialVersionUID = 3787452961716324977L;

  @ApiModelProperty(value = "ID", example = "AadfKnG07n")
  private String id;

  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Alert Text ID", example = "EssaJ4W0Js")
  private String alertText;

  @RemoveTrailingSpaces
  @Size(max = 10)
  @ApiModelProperty(value = "Approval Number ID", example = "GIxeGnJ00u")
  private String approvalNumber;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Approval Status Code", example = "118")
  private short approvalStatus;

  @RemoveTrailingSpaces
  @ApiModelProperty(required = true, value = "Case Closure Reason Code", example = "306")
  private short caseClosureReason;

  @NotNull
  @ApiModelProperty(
      required = true,
      value = "Caseplan children detail existing indicator",
      example = "true"
  )
  private boolean caseplanChildrenDetail;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Case closure statement text ID", example = "Fn3lUdY00F")
  private String closureStatementText;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Country Code", example = "563")
  private short country;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "County Code", example = "10")
  private String countySpecificCode;

  @RemoveTrailingSpaces
  @ApiModelProperty(value = "DRMS notes document ID", example = "At9HoSn0WJ")
  private String drmsNotesDoc;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @ApiModelProperty(
      value = "The anticipated date the child client will become emancipated",
      example = "2018-10-20"
  )
  private LocalDate emancipationDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @ApiModelProperty(value = "End date", example = "2018-10-20")
  private LocalDate endDate;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Child Client ID", example = "8m7hS7i07n")
  private String childClient;

  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Referral ID", example="7Rgxy9S00T")
  private String referralId;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Staff Person ID", example="07n")
  private String staffPerson;

  @RemoveTrailingSpaces
  @ApiModelProperty(
      value = "Code of the county within the state of California to which a specific CASE is assigned",
      example = "1068"
  )
  private short county;

  @NotNull
  @ApiModelProperty(
      required = true,
      value = "ICPC outgoing placement status indicator",
      example = "true"
  )
  private boolean icpcOutgoingPlacementStatus;

  @NotNull
  @ApiModelProperty(required = true, value = "ICPC outgoing request indicator", example = "true")
  private boolean icpcOutgoingRequest;

  @RemoveTrailingSpaces
  @Size(min = 1, max = 1)
  @OneOf(
      value = {"N", "R", "S"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(required = true, value = "Security access level code", example = "S")
  private String limitedAccess;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @ApiModelProperty(value = "Limited access date", example = "2016-10-25")
  private LocalDate limitedAccessDate;

  @RemoveTrailingSpaces
  @ApiModelProperty(value = "Limited access description", example = "Text")
  private String limitedAccessDesc;

  @ApiModelProperty(value = "Limited access county", example = "1068")
  private Short limitedAccessCounty;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "Case name", example = "Sibling Hanson")
  private String caseName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @ApiModelProperty(
      value = "Next Transitional Independent Living Plan due date",
      example = "2018-10-24"
  )
  private LocalDate nextTilpDueDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @ApiModelProperty(
      value = "Next Transitional Independent Living Plan due date",
      example = "2018-10-23"
  )
  private LocalDate projectedEndDate;

  @RemoveTrailingSpaces
  @Size(min = 1, max = 1)
  @OneOf(
      value = {"A", "C", "I", "K", "M", "O", "P", "S"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(value = "Responsible agency code", example = "A")
  private String responsibleAgency;

  @NotNull
  @ApiModelProperty(required = true, value = "Special case project indicator", example = "true")
  private Boolean specialProjectCase;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @NotNull
  @ApiModelProperty(required = true, value = "Start date", example = "2016-10-23")
  private LocalDate startDate;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(required = true, value = "State", example = "1828")
  private short state;

  @RemoveTrailingSpaces
  @NotNull
  @ApiModelProperty(
      required = true,
      value = "Code of the service component being referenced for a child's case",
      example = "1692"
  )
  private short activeServiceComponent;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date
  @NotNull
  @ApiModelProperty(required = true, value = "Service component start date", example = "2016-10-23")
  private LocalDate activeServiceComponentStartDate;

  @NotNull
  @ApiModelProperty(required = true, value = "Tickle indicator", example = "true")
  private Boolean tickle;

}
