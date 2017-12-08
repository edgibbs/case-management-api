package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.cm.service.mapper.ReferralMapper;
import gov.ca.cwds.data.legacy.cms.dao.ReferralDao;
import gov.ca.cwds.data.legacy.cms.entity.Referral;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/** @author CWDS TPT-3 Team */
public class ReferralService extends CrudServiceAdapter {

  private ReferralDao referralDao;
  private ReferralMapper referralMapper;

  @Inject
  public ReferralService(
      ReferralDao referralDao, ReferralMapper referralMapper) {
    this.referralDao = referralDao;
    this.referralMapper = referralMapper;
  }

  public List<ReferralDTO> getReferralsByStaffId(String staffId) {
    List<Referral> referrals = referralDao.getOpenReferralsByStaffId(staffId, LocalDate.now());
    return referrals

        .stream()
        .map(referral -> referralMapper.toReferralDTO(referral))
        .collect(Collectors.toList());
  }
}
