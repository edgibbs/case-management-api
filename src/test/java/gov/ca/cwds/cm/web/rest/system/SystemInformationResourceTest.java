package gov.ca.cwds.cm.web.rest.system;

import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.dto.system.HealthCheckResultDTO;
import gov.ca.cwds.cm.service.dto.system.SystemInformationDTO;
import gov.ca.cwds.cm.BaseApiIntegrationTest;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by CWDS TPT-3 Team
 */
public class SystemInformationResourceTest extends BaseApiIntegrationTest {

  @Test
  public void testSystemInformationGet() throws IOException {
    SystemInformationDTO systemInformationDTO = clientTestRule
        .target(Constants.API.SYSTEM_INFORMATION_PATH)
        .request(MediaType.APPLICATION_JSON)
        .get(SystemInformationDTO.class);
    assertEquals("CWDS CASE MANAGEMENT API", systemInformationDTO.getApplication());
    assertNotNull(systemInformationDTO.getVersion());

    assertDeadlocks(systemInformationDTO.getDeadlocks());
    assertDataSource(systemInformationDTO.getCwscms());
  }

  public void assertDeadlocks(HealthCheckResultDTO healthCheckResultDTO) {
    assertNotNull(healthCheckResultDTO);
    assertTrue(healthCheckResultDTO.isHealthy());
  }
  public void assertDataSource(HealthCheckResultDTO healthCheckResultDTO) {
    assertNotNull(healthCheckResultDTO);
    assertTrue(healthCheckResultDTO.isHealthy());
  }
}
