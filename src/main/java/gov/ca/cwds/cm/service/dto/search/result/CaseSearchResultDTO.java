package gov.ca.cwds.cm.service.dto.search.result;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public final class CaseSearchResultDTO extends SearchResultDTO<CaseDTO> {

  private static final long serialVersionUID = -8084255894358271330L;

}
