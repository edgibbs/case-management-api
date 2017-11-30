package gov.ca.cwds.cm.web.rest.dto.request;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class ClientsSearchCriteria implements Serializable {
  private static final long serialVersionUID = -26931917990681210L;

  private String staffId;
}
