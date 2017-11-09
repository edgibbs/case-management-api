package gov.ca.cwds.cm.service.dto;

public enum ApprovalStatus {

	APPROVED("0005","Approved"),
	PENDING_APPROVAL("0002", "Pending Approval"),
	PENDING_HIGHER_APPROVAL("0006", "Pending Higher Approval"),
	REJECTED("0004", "Rejected"),
	REQUEST_NOT_SUBMITTED("0001", "Request Not Submitted"),
	REQUIRES_MODIFICATION("0003", "Requires Modification");

	private String code;
	private String value;

	ApprovalStatus(String code, String value) {
		this.code = code;
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}
}
