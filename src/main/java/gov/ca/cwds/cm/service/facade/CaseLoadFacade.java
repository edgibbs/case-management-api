package gov.ca.cwds.cm.service.facade;

import static com.google.common.collect.MoreCollectors.onlyElement;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.ReferralService;
import gov.ca.cwds.cm.service.dictionaries.AssignmentType;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.data.legacy.cms.dao.AssignmentDao;
import gov.ca.cwds.data.legacy.cms.entity.BaseAssignment;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/** @author CWDS TPT-3 Team */
public class CaseLoadFacade {

  private AssignmentDao assignmentDao;
  private ReferralService referralService;

  @Inject
  public CaseLoadFacade(AssignmentDao assignmentDao,
      ReferralService referralService) {
    this.assignmentDao = assignmentDao;
    this.referralService = referralService;
  }

  public List<ReferralDTO> getReferralsWithActiveAssignment(String staffId) throws IOException {
    List<ReferralDTO> referrals = referralService.getReferralsByStaffId(staffId);
    List<BaseAssignment> assignments =
        assignmentDao.getAssignmentsByStaffIds(
            referrals.stream().map(ReferralDTO::getIdentifier).collect(Collectors.toList()));
    return referrals
        .stream()
        .map(referral -> enrichReferralDtos(referral, assignments))
        .collect(Collectors.toList());
  }

  private ReferralDTO enrichReferralDtos(
      final ReferralDTO referralDTO, final List<BaseAssignment> assignment) {
    Character assignmentType = assignment
        .stream()
        .filter(line -> line.getEstablishedForId().equals(referralDTO.getIdentifier()))
        .collect(onlyElement()).getAssignmentType().getCode();

    referralDTO.setAssignmentType(
        AssignmentType.from(
            assignmentType
        )
    );
    return referralDTO;
  }
}
