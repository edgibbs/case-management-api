package gov.ca.cwds.cm.service;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import gov.ca.cwds.cm.service.dto.facade.CaseByStaff;
import gov.ca.cwds.cm.service.mapper.CaseMapper;
import gov.ca.cwds.cm.service.mapper.facade.CaseByStaffMapper;
import gov.ca.cwds.data.legacy.cms.dao.CaseDao;
import gov.ca.cwds.data.legacy.cms.entity.Case;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

public class CaseService extends TypedCrudServiceAdapter {

  private final CaseDao caseDao;
  private final CaseMapper caseMapper;
  private final CaseByStaffMapper caseByStaffMapper;

  @Inject
  public CaseService(CaseDao caseDao, CaseMapper caseMapper, CaseByStaffMapper caseByStaffMapper) {
    this.caseDao = caseDao;
    this.caseMapper = caseMapper;
    this.caseByStaffMapper = caseByStaffMapper;
  }

  @Override
  public CaseDTO find(Serializable param) {
    Case caseEntity = caseDao.find(param);
    return caseMapper.toCaseDTO(caseEntity);
  }

  public Collection<CaseByStaff> findActiveByStaffId(final String staffId) {
    final Collection<Case> cases = caseDao.findByStaffIdAndActiveDate(staffId, LocalDate.now());
    return cases.stream()
        .map(theCase -> caseByStaffMapper.toView(theCase, staffId))
        .collect(Collectors.toList());
  }
}
