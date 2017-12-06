package gov.ca.cwds.cm.service.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import gov.ca.cwds.ObjectMapperUtils;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import io.dropwizard.testing.FixtureHelpers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author CWDS TPT-3 Team
 */
public class CaseLoadFacade {

  public List<ReferralDTO> getReferralsWithActiveAssignment(String referralId) throws IOException {
    if ("-1".equals(referralId)) {
      return new ArrayList<>(0);
    }
    return Arrays.asList(getMockedData());
  }

  private static ReferralDTO[] getMockedData() throws IOException {
    ObjectMapper objectMapper = ObjectMapperUtils.createObjectMapper();
    objectMapper.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    String json = FixtureHelpers.fixture("fixtures/referrals_by_staff_id_mock.json");
    return objectMapper.readValue(json, ReferralDTO[].class);
  }

}
