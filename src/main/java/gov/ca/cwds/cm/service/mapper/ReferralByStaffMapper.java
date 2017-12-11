package gov.ca.cwds.cm.service.mapper;

/**
 * @author CWDS TPT-3 Team
 */
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.cm.service.dto.facade.ReferralByStaff;
import gov.ca.cwds.cm.service.mapper.tool.LegacyBooleanToStringMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/** @author CWDS TPT-3 Team */
@Mapper(uses = {LegacyBooleanToStringMapper.class, ReferralMapper.class})
@FunctionalInterface
public interface ReferralByStaffMapper {

  @Mapping(ignore = true, target = "assignmentType")
  ReferralByStaff toReferral(ReferralDTO referral);
}
