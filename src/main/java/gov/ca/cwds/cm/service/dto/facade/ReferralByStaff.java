package gov.ca.cwds.cm.service.dto.facade;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.data.legacy.cms.entity.enums.AssignmentType;
import gov.ca.cwds.rest.api.Response;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ReferralByStaff extends ReferralDTO implements Response {

  private static final long serialVersionUID = 4504908645901963401L;

  private AssignmentType assignmentType;

}
