package gov.ca.cwds.cm.service.dto;

public enum CaseClosureReason {

	ADOPTION_FINALIZED_FORMER_FOSTER_PARENT("0026", "Adoption Finalized/Former Foster Parent"),
	ADOPTION_FINALIZED_NON_RELATIVE("0028", "Adoption Finalized/Non-Relative"),
	ADOPTION_FINALIZED_RELATIVE("0027", "Adoption Finalized/Relative"),
	AGE_LIMI_EXIT("0051", "Age Limit Exit"),
	CHANGE_FROM_601_602_TO_300_DEPENDENCY("0029", "Change from 601/602 to 300 Dependency"),
	CHILD_ABDUCTED("0046", "Child Abducted"),
	CHILD_COMMITTED_TO_STATE_HOSPITAL("0044", "Child Committed to State Hospital"),
	CHILD_IN_MEDIC_FAC_DEPEN_DISMSD_OR_SUSP("0029", "Child in Medic Fac/Depen Dismsd or Susp"),
	CHILD_REC_SVCS_FROM_PROBATION_CASE_SUSP("0002", "Child rec svcs from Probation, Case Susp"),
	CHILD_RUNAWAY("0034", "Child Runaway"),
	CLOSE_ICPC_INTERNATIONAL_REQUEST("0035", "Closed ICPC/International Request"),
	CONVERSATION_ICT("0036", "Conversion (ICT)"),
	COURT_ORDERED_TERMINATION("0029", "Court Ordered Termination"),
	DEATH_OF_CHILD("0001", "Death of Child"),
	EMANCIPATION_AGE_OF_MAJORITY("0030", "Emancipation/Age of Majority"),
	EXCEED_TIME_LIMIT("0048", "Exceeded Time Limit"),
	FAMILY_STABILIZED("0023", "Family Stabilized (FM)"),
	GUARDIANSHIP_ESTABLISHED_CHILD_PLACED("0042", "Guardianship Established/Child Placed"),
	INCARCERATED_ADJUDICATED_601_602("0043", "Incarcerated - Adjudicated 601/602"),
	INCARCERATED_ADJUDICATED_NON_601_602("0025", "Incarcerated - Adjudicated Non 601/602"),
	KIN_GAP("0027", "Kin-GAP"),
	NMD_ELIGIBLE_FOR_REENTRY("0049", "NMD Eligible for Reentry"),
	NOT_INCARCERATED_ADJUDICATE_601_602("0026", "Not Incarcerated - Adjudicate 601/602"),
	NRLG_ELIGIBLE_FOR_REENTRY("0050", "NRLG Eligible for Reentry"),
	PLACEMENT_WITH_RELATIVE("0025", "Placement with Relative"),
	RE_UNIFIED_WITH_PARENT_GUARDIAN_COURT("0023", "Re-Unified With Parent/Guardian (Court)"),
	RE_UNIFIED_WITH_PARENT_GUARDIAN_NON_COURT("0023", "Re-Unified With Parent/Guardian(Non-Crt)"),
	REFUSED_SERVICES("0047", "Refused Services"),
	SERVICES_PROVIDED_BY_ADOPTION_AGENCY("0041", "Services Provided By Adoption Agency"),
	SERVICES_PROVIDED_BY_OTHER_AGENCY("0036", "Services Provided By Other Agency"),
	TRANSFERED_TO_TRIBAL_JUR_OUTSIDE_OF_CA("0035", "Transferred to Tribal Jur Outside of CA"),
	UNKNOWN_AT_CONVERSATION("0024", "Unknown at Conversion");

	private String code;
	private String value;

	CaseClosureReason(String code, String value) {
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
