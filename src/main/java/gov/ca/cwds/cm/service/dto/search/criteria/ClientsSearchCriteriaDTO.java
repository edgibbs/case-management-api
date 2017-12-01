package gov.ca.cwds.cm.service.dto.search.criteria;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(description = "Client search will be executed by this criteria")
public class ClientsSearchCriteriaDTO extends BaseCriteriaDTO {
  private static final long serialVersionUID = -26931917990681210L;

  @ApiModelProperty(
      example = "122AD"
  )
  private String staffId;
}
