package gov.ca.cwds.cm.service.dto.search.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dto.ClientDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/** @author CWDS TPT-3 Team */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ClientSearchResultDTO extends SearchResultDTO<ClientDTO> {
  private static final long serialVersionUID = -5138391358634934419L;
}
