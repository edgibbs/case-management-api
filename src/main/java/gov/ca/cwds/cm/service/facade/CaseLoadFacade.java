package gov.ca.cwds.cm.service.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.inject.Inject;
import gov.ca.cwds.ObjectMapperUtils;
import gov.ca.cwds.cm.service.ReferralService;
import gov.ca.cwds.cm.service.dictionaries.AssignmentType;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.cm.service.mapper.ReferralMapper;
import gov.ca.cwds.data.legacy.cms.dao.AssignmentDao;
import gov.ca.cwds.data.legacy.cms.entity.BaseAssignment;
import gov.ca.cwds.data.legacy.cms.entity.Referral;
import io.dropwizard.testing.FixtureHelpers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        assignmentDao.getOpenAssignmentsByStaffIds(
            referrals.stream().map(ReferralDTO::getIdentifier).collect(Collectors.toList()));
    return referrals
        .stream()
        .map(referral -> enrichReferralDtos(referral, assignments))
        .collect(Collectors.toList());
  }

  private ReferralDTO enrichReferralDtos(
      final ReferralDTO referralDTO, final List<BaseAssignment> assignment) {
    referralDTO.setAssignmentType(
        AssignmentType.from(
            assignment
                .stream()
                .filter(line -> line.getEstablishedForId().equals(referralDTO.getIdentifier()))
                .findAny()
                .orElse(null)
                .getAssignmentType().getCode()));
    return referralDTO;
  }
}
