package gov.ca.cwds.cm.service.facade;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.CaseService;
import gov.ca.cwds.cm.service.ReferralService;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.cm.service.dto.facade.CaseByStaff;
import gov.ca.cwds.cm.service.dto.facade.ReferralByStaff;
import gov.ca.cwds.cm.service.mapper.ReferralByStaffMapper;
import gov.ca.cwds.data.legacy.cms.dao.AssignmentDao;
import gov.ca.cwds.data.legacy.cms.entity.BaseAssignment;
import gov.ca.cwds.data.legacy.cms.entity.enums.AssignmentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/** @author CWDS TPT-3 Team */
public class CaseLoadFacade {

  private AssignmentDao assignmentDao;
  private ReferralService referralService;
  private CaseService caseService;
  private ReferralByStaffMapper referralByStaffMapper;

  @Inject
  public CaseLoadFacade(
      AssignmentDao assignmentDao, ReferralService referralService, CaseService caseService, ReferralByStaffMapper referralByStaffMapper) {
    this.assignmentDao = assignmentDao;
    this.referralService = referralService;
    this.caseService = caseService;
    this.referralByStaffMapper = referralByStaffMapper;
  }

  public List<ReferralByStaff> getReferralsWithActiveAssignment(String staffId) throws IOException {
    List<ReferralByStaff> referrals = referralService.getReferralsByStaffId(staffId).stream().map(t -> referralByStaffMapper.toReferral(t)).collect(
        Collectors.toList());
    List<BaseAssignment> assignments =
        assignmentDao.getAssignmentsByStaffIds(
            referrals.stream().map(ReferralDTO::getIdentifier).collect(Collectors.toList()));
    return referrals
        .stream()
        .map(referral -> enrichReferralDtos(referral, assignments))
        .collect(Collectors.toList());
  }

  public List<CaseByStaff> getActiveCases(String staffId) {
    return new ArrayList<>(caseService.findActiveByStaffId(staffId));
  }

  private ReferralByStaff enrichReferralDtos(
      final ReferralByStaff referralDTO, final List<BaseAssignment> assignment) {
    AssignmentType assignmentType =
        assignment
            .stream()
            .filter(line -> line.getEstablishedForId().equals(referralDTO.getIdentifier()))
            .findAny().orElse(null)
            .getAssignmentType();
    referralDTO.setAssignmentType(assignmentType);
    return referralDTO;
  }
}
