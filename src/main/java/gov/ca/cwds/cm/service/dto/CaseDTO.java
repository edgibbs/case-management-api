package gov.ca.cwds.cm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.RequestResponse;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

/** @author CWDS TPT-3 Team */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CaseDTO extends BaseDTO implements RequestResponse {

  private static final long serialVersionUID = 3787452961716324977L;

  private String id;

  @ApiModelProperty(value = "Alert Text", example = "Text")
  private String alertText;

  @Size(max = 10)
  @ApiModelProperty(value = "Approval Number", example = "100")
  private String approvalNumber;

  @NotNull
  @ApiModelProperty(required = true, value = "Approval Status", example = "100")
  private String approvalStatus;

  @ApiModelProperty(required = true, value = "Approval Status", example = "Child Abducted")
  private String caseClosureReason;

  @NotNull
  @ApiModelProperty(
    required = true,
    value = "Caseplan children detail existing indicator.",
    example = "true"
  )
  private Boolean isCaseplanChildrenDetail;

  @NotNull
  @ApiModelProperty(required = true, value = "Case closure statement text", example = "Text")
  private String closureStatementText;

  @NotNull
  @ApiModelProperty(required = true, value = "Country", example = "US")
  private String country;

  @NotNull
  @ApiModelProperty(required = true, value = "County", example = "Alameda")
  private String countySpecificCode;

  @ApiModelProperty(value = "DRMS notes", example = "Text")
  private String drmsNotesDoc;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value = "The anticipated date the child client will become emancipated.",
    example = "2018-10-20"
  )
  private LocalDate emancipationDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @ApiModelProperty(value = "End date.", example = "2018-10-20")
  private LocalDate endDate;

  @NotNull
  @ApiModelProperty(required = true, value = "Child")
  private String childClient;

  @ApiModelProperty(value = "Referrer")
  private String referralId;

  @NotNull
  @ApiModelProperty(required = true, value = "Staff Person")
  private String staffPerson;

  @ApiModelProperty(
    value = "County within the state of California to which a specific CASE is assigned.",
    example = "Alameda"
  )
  private String county;

  @NotNull
  @ApiModelProperty(
    required = true,
    value = "ICPC outgoing placement status indicator.",
    example = "true"
  )
  private Boolean isIcpcOutgoingPlacementStatus;

  @NotNull
  @ApiModelProperty(required = true, value = "ICPC outgoing request", example = "true")
  private Boolean isIcpcOutgoingRequest;

  @NotNull
  @ApiModelProperty(required = true, value = "Determine the security access level.", example = "S")
  private String limitedAccess;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @ApiModelProperty(value = "Limited access date", example = "2016-10-25")
  private LocalDate limitedAccessDate;

  @ApiModelProperty(value = "Limited access description", example = "Text")
  private String limitedAccessDesc;

  @ApiModelProperty(value = "Limited access county", example = "Alameda")
  private Short limitedAccessCounty;

  @NotNull
  @ApiModelProperty(required = true, value = "Case name")
  private String caseName;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value = "Next Transitional Independent Living Plan due date",
    example = "2018-10-24"
  )
  private LocalDate nextTilpDueDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value = "Next Transitional Independent Living Plan due date",
    example = "2018-10-23"
  )
  private LocalDate projectedEndDate;

  @ApiModelProperty(value = "Responsible agency")
  private String responsibleAgency;

  @NotNull
  @ApiModelProperty(required = true, value = "Special case project indicator", example = "true")
  private Boolean isSpecialProjectCase;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @NotNull
  @ApiModelProperty(required = true, value = "Start date", example = "2016-10-23")
  private LocalDate startDate;

  @NotNull
  @ApiModelProperty(required = true, value = "State", example = "CA")
  private String state;

  @NotNull
  @ApiModelProperty(
    required = true,
    value = "Service component being referenced  for a child's case",
    example = "Emergency Response"
  )
  private String activeServiceComponent;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @gov.ca.cwds.rest.validation.Date(format = DATE_FORMAT)
  @NotNull
  @ApiModelProperty(required = true, value = "Service component start date", example = "2016-10-23")
  private LocalDate activeServiceComponentStartDate;

  @NotNull
  @ApiModelProperty(required = true, value = "Tickle indicator", example = "true")
  private Boolean isTickle;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAlertText() {
    return alertText;
  }

  public void setAlertText(String alertText) {
    this.alertText = alertText;
  }

  public String getApprovalNumber() {
    return approvalNumber;
  }

  public void setApprovalNumber(String approvalNumber) {
    this.approvalNumber = approvalNumber;
  }

  public String getApprovalStatus() {
    return approvalStatus;
  }

  public void setApprovalStatus(String approvalStatus) {
    this.approvalStatus = approvalStatus;
  }

  public String getCaseClosureReason() {
    return caseClosureReason;
  }

  public void setCaseClosureReason(String caseClosureReason) {
    this.caseClosureReason = caseClosureReason;
  }

  public Boolean getCaseplanChildrenDetail() {
    return isCaseplanChildrenDetail;
  }

  public void setCaseplanChildrenDetail(Boolean caseplanChildrenDetail) {
    isCaseplanChildrenDetail = caseplanChildrenDetail;
  }

  public String getClosureStatementText() {
    return closureStatementText;
  }

  public void setClosureStatementText(String closureStatementText) {
    this.closureStatementText = closureStatementText;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getCountySpecificCode() {
    return countySpecificCode;
  }

  public void setCountySpecificCode(String countySpecificCode) {
    this.countySpecificCode = countySpecificCode;
  }

  public String getDrmsNotesDoc() {
    return drmsNotesDoc;
  }

  public void setDrmsNotesDoc(String drmsNotesDoc) {
    this.drmsNotesDoc = drmsNotesDoc;
  }

  public LocalDate getEmancipationDate() {
    return emancipationDate;
  }

  public void setEmancipationDate(LocalDate emancipationDate) {
    this.emancipationDate = emancipationDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public String getChildClient() {
    return childClient;
  }

  public void setChildClient(String childClient) {
    this.childClient = childClient;
  }

  public String getReferralId() {
    return referralId;
  }

  public void setReferralId(String referralId) {
    this.referralId = referralId;
  }

  public String getStaffPerson() {
    return staffPerson;
  }

  public void setStaffPerson(String staffPerson) {
    this.staffPerson = staffPerson;
  }

  public String getCounty() {
    return county;
  }

  public void setCounty(String county) {
    this.county = county;
  }

  public Boolean getIcpcOutgoingPlacementStatus() {
    return isIcpcOutgoingPlacementStatus;
  }

  public void setIcpcOutgoingPlacementStatus(Boolean icpcOutgoingPlacementStatus) {
    isIcpcOutgoingPlacementStatus = icpcOutgoingPlacementStatus;
  }

  public Boolean getIcpcOutgoingRequest() {
    return isIcpcOutgoingRequest;
  }

  public void setIcpcOutgoingRequest(Boolean icpcOutgoingRequest) {
    isIcpcOutgoingRequest = icpcOutgoingRequest;
  }

  public String getLimitedAccess() {
    return limitedAccess;
  }

  public void setLimitedAccess(String limitedAccess) {
    this.limitedAccess = limitedAccess;
  }

  public LocalDate getLimitedAccessDate() {
    return limitedAccessDate;
  }

  public void setLimitedAccessDate(LocalDate limitedAccessDate) {
    this.limitedAccessDate = limitedAccessDate;
  }

  public String getLimitedAccessDesc() {
    return limitedAccessDesc;
  }

  public void setLimitedAccessDesc(String limitedAccessDesc) {
    this.limitedAccessDesc = limitedAccessDesc;
  }

  public Short getLimitedAccessCounty() {
    return limitedAccessCounty;
  }

  public void setLimitedAccessCounty(Short limitedAccessCounty) {
    this.limitedAccessCounty = limitedAccessCounty;
  }

  public String getCaseName() {
    return caseName;
  }

  public void setCaseName(String caseName) {
    this.caseName = caseName;
  }

  public LocalDate getNextTilpDueDate() {
    return nextTilpDueDate;
  }

  public void setNextTilpDueDate(LocalDate nextTilpDueDate) {
    this.nextTilpDueDate = nextTilpDueDate;
  }

  public LocalDate getProjectedEndDate() {
    return projectedEndDate;
  }

  public void setProjectedEndDate(LocalDate projectedEndDate) {
    this.projectedEndDate = projectedEndDate;
  }

  public String getResponsibleAgency() {
    return responsibleAgency;
  }

  public void setResponsibleAgency(String responsibleAgency) {
    this.responsibleAgency = responsibleAgency;
  }

  public Boolean getSpecialProjectCase() {
    return isSpecialProjectCase;
  }

  public void setSpecialProjectCase(Boolean specialProjectCase) {
    isSpecialProjectCase = specialProjectCase;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getActiveServiceComponent() {
    return activeServiceComponent;
  }

  public void setActiveServiceComponent(String activeServiceComponent) {
    this.activeServiceComponent = activeServiceComponent;
  }

  public LocalDate getActiveServiceComponentStartDate() {
    return activeServiceComponentStartDate;
  }

  public void setActiveServiceComponentStartDate(LocalDate activeServiceComponentStartDate) {
    this.activeServiceComponentStartDate = activeServiceComponentStartDate;
  }

  public Boolean getTickle() {
    return isTickle;
  }

  public void setTickle(Boolean tickle) {
    isTickle = tickle;
  }
}
