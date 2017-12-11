package gov.ca.cwds.cm.service.dto.facade;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dictionaries.AssignmentType;
import gov.ca.cwds.cm.service.dto.BaseDTO;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.rest.api.Response;

/**
 * @author CWDS TPT-3 Team
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReferralByStaff extends BaseDTO implements Response {

  private static final long serialVersionUID = 4504908645901963401L;

  private ReferralDTO referral;
  private AssignmentType assignmentType;

  public ReferralByStaff(ReferralDTO referralDTO,
      AssignmentType assignmentType) {
    this.referral = referralDTO;
    this.assignmentType = assignmentType;
  }

  public ReferralDTO getReferral() {
    return referral;
  }

  public void setReferral(ReferralDTO referral) {
    this.referral = referral;
  }

  public AssignmentType getAssignmentType() {
    return assignmentType;
  }

  public void setAssignmentType(AssignmentType assignmentType) {
    this.assignmentType = assignmentType;
  }
}
