package gov.ca.cwds.cm.service.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CaseDTO extends BaseDTO{

	private static final long serialVersionUID = 3787452961716324977L;

	private String id;

	@ApiModelProperty(value = "Alert Text", example = "")
	private String alertText;

	@Size(max = 10)
	@ApiModelProperty(value = "Approval Number", example = "100")
	private String approvalNumber;

	//approvalStatusType
	@NotNull
	@ApiModelProperty(required = true, value = "Approval Status", example = "100")
	private ApprovalStatus approvalStatus;

	//caseClosureReasonType
	@ApiModelProperty(required = true, value = "Approval Status", example = "Child Abducted")
	private CaseClosureReason caseClosureReason;

	//caseplanChildrenDetailIndVar
	private Boolean isCaseplanChildrenDetail;

	private String closureStatementText;

	//countryCodeType
	private String country;

	@NotNull
	private String countySpecificCode;

	private String drmsNotesDoc;

	private String emancipationDate;

	private Date endDate;

	//fkchldClt
	private String childClient;

	private String fkreferlt;

	private String staffPerson;

	//governmentEntityType
	@ApiModelProperty(value = "County within the state of California to which a specific CASE is assigned.", example = "Alameda")
	private Short governmentEntityType;

	//icpcOutgngPlcmtStatusIndVar
	private Boolean isIcpcOutgoingPlacementStatus;

	//icpcOutgoingRequestIndVar
	private Boolean isIcpcOutgoingRequest;

	private String limitedAccessCode;

	private Date limitedAccessDate;

	private String limitedAccessDesc;

	//limitedAccessGovernmentEntityType
	private Short limitedAccessChangedCounty;

	private String caseName;

	private Date nextTILPDueDate;

	private Date projectedEndDate;

	private String responsibleAgencyCode;

	private Boolean isSpecialProjectCase;

	private Date startDate;

	//stateCodeType
	private Short state;

	//activeServiceComponentType
	private Short activeServiceComponent;

	//activeSvcComponentStartDate
	private Date activeServiceComponentStartDate;

	//tickleIndVar
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

	public ApprovalStatus getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(ApprovalStatus approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public CaseClosureReason getCaseClosureReason() {
		return caseClosureReason;
	}

	public void setCaseClosureReason(CaseClosureReason caseClosureReason) {
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

	public String getEmancipationDate() {
		return emancipationDate;
	}

	public void setEmancipationDate(String emancipationDate) {
		this.emancipationDate = emancipationDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getChildClient() {
		return childClient;
	}

	public void setChildClient(String childClient) {
		this.childClient = childClient;
	}

	public String getFkreferlt() {
		return fkreferlt;
	}

	public void setFkreferlt(String fkreferlt) {
		this.fkreferlt = fkreferlt;
	}

	public String getStaffPerson() {
		return staffPerson;
	}

	public void setStaffPerson(String staffPerson) {
		this.staffPerson = staffPerson;
	}

	public Short getGovernmentEntityType() {
		return governmentEntityType;
	}

	public void setGovernmentEntityType(Short governmentEntityType) {
		this.governmentEntityType = governmentEntityType;
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

	public String getLimitedAccessCode() {
		return limitedAccessCode;
	}

	public void setLimitedAccessCode(String limitedAccessCode) {
		this.limitedAccessCode = limitedAccessCode;
	}

	public Date getLimitedAccessDate() {
		return limitedAccessDate;
	}

	public void setLimitedAccessDate(Date limitedAccessDate) {
		this.limitedAccessDate = limitedAccessDate;
	}

	public String getLimitedAccessDesc() {
		return limitedAccessDesc;
	}

	public void setLimitedAccessDesc(String limitedAccessDesc) {
		this.limitedAccessDesc = limitedAccessDesc;
	}

	public Short getLimitedAccessChangedCounty() {
		return limitedAccessChangedCounty;
	}

	public void setLimitedAccessChangedCounty(Short limitedAccessChangedCounty) {
		this.limitedAccessChangedCounty = limitedAccessChangedCounty;
	}

	public String getCaseName() {
		return caseName;
	}

	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}

	public Date getNextTILPDueDate() {
		return nextTILPDueDate;
	}

	public void setNextTILPDueDate(Date nextTILPDueDate) {
		this.nextTILPDueDate = nextTILPDueDate;
	}

	public Date getProjectedEndDate() {
		return projectedEndDate;
	}

	public void setProjectedEndDate(Date projectedEndDate) {
		this.projectedEndDate = projectedEndDate;
	}

	public String getResponsibleAgencyCode() {
		return responsibleAgencyCode;
	}

	public void setResponsibleAgencyCode(String responsibleAgencyCode) {
		this.responsibleAgencyCode = responsibleAgencyCode;
	}

	public Boolean getSpecialProjectCase() {
		return isSpecialProjectCase;
	}

	public void setSpecialProjectCase(Boolean specialProjectCase) {
		isSpecialProjectCase = specialProjectCase;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Short getActiveServiceComponent() {
		return activeServiceComponent;
	}

	public void setActiveServiceComponent(Short activeServiceComponent) {
		this.activeServiceComponent = activeServiceComponent;
	}

	public Date getActiveServiceComponentStartDate() {
		return activeServiceComponentStartDate;
	}

	public void setActiveServiceComponentStartDate(Date activeServiceComponentStartDate) {
		this.activeServiceComponentStartDate = activeServiceComponentStartDate;
	}

	public Boolean getTickle() {
		return isTickle;
	}

	public void setTickle(Boolean tickle) {
		isTickle = tickle;
	}
}

