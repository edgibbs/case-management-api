package gov.ca.cwds.cm.service;

import gov.ca.cwds.cm.service.dto.SafetyAlertDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SafetyAlertService {

  public static final String ALL_ZEROS = "0000000000";

  public Collection<SafetyAlertDTO> findSafetyAlertsByClientId(String clientId) {
    if (!clientId.equals(ALL_ZEROS)) return getMockedData();
    return Collections.emptyList();
  }

  private Collection<SafetyAlertDTO> getMockedData() {
    List<SafetyAlertDTO> safetyAlertDTOList = new ArrayList<>();

    SafetyAlertDTO safetyAlertDTO1 = new SafetyAlertDTO();
    safetyAlertDTO1.setClientId("1234567890");
    safetyAlertDTO1.setActivationDate(LocalDate.of(2014, 10, 5));
    safetyAlertDTO1.setActivationGovermentEntityType((short) 1068);
    safetyAlertDTO1.setActivationExplanationTextId("8Dz06wW0X5");
    safetyAlertDTO1.setActivationReasonType((short) 6401);
    safetyAlertDTO1.setThirdId(ALL_ZEROS);

    SafetyAlertDTO safetyAlertDTO2 = new SafetyAlertDTO();
    safetyAlertDTO2.setClientId("1234567890");
    safetyAlertDTO2.setActivationDate(LocalDate.of(2013, 1, 2));
    safetyAlertDTO2.setActivationGovermentEntityType((short) 1068);
    safetyAlertDTO2.setActivationExplanationTextId("8Dz06wRTX5");
    safetyAlertDTO2.setActivationReasonType((short) 6402);
    safetyAlertDTO2.setDeactivationGovermentEntityType((short) 1069);
    safetyAlertDTO2.setDeactivationDate(LocalDate.of(2013, 1, 15));
    safetyAlertDTO2.setDeactivationExplanationTextId("8Dz06wEWX5");
    safetyAlertDTO2.setThirdId(ALL_ZEROS);

    safetyAlertDTOList.add(safetyAlertDTO1);
    safetyAlertDTOList.add(safetyAlertDTO2);

    return safetyAlertDTOList;
  }
}
