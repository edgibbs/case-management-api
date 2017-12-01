package gov.ca.cwds.cm.service.dto.search.criteria;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(description = "The case search will be executed by this criteria")
public class CaseCriteriaDTO extends BaseCriteriaDTO {

  private static final long serialVersionUID = -5992563772783219351L;

  @Length(max = 3)
  @ApiModelProperty(
      value = "The field is to search for cases by staff id. It is id of Staff who owns Caseloads "
          + "which contain Cases to return as a search result.",
      example = "q58"
  )
  private String staffId;

}
