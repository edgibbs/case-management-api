package gov.ca.cwds.cm.service.dto.search.criteria;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.rest.api.Request;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(description = "Base Criteria DTO. Contains pagination and sorting. "
    + "To be extended by concrete criteria.")
public abstract class BaseCriteriaDTO implements Request {

  private static final long serialVersionUID = 6438442814651274084L;

  private PaginationDTO pagination;
  private SortDTO sort;

}
