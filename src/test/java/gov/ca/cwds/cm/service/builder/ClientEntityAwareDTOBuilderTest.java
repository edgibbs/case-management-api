package gov.ca.cwds.cm.service.builder;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import gov.ca.cwds.cms.data.access.dto.ClientEntityAwareDTO;
import gov.ca.cwds.data.legacy.cms.entity.Client;
import org.junit.Test;

public class ClientEntityAwareDTOBuilderTest {

  @Test
  public void testBuild() {
    Client client = new Client();

    ClientEntityAwareDTOBuilder builder = new ClientEntityAwareDTOBuilder(client);

    ClientEntityAwareDTO dto = builder.build();
    assertNotNull(dto);

    Client client2 = dto.getEntity();
    assertTrue(client == client2);
  }
}
