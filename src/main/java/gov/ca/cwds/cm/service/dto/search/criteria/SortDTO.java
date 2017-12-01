package gov.ca.cwds.cm.service.dto.search.criteria;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(description = "Contains sort fields for search requests")
public class SortDTO implements Serializable {
  private static final long serialVersionUID = -1334777313765934106L;

  @ApiModelProperty(
      value = "Contains an entities field name. Search results will be sorted by this field.",
      example = "id"
  )
  private String sortBy;

  @ApiModelProperty(
      value = "Contains an entities field name. Search results will be sorted by this field. "
          + "Default value is DESC.",
      example = "ASC",
      allowableValues = "ASC, DESC"
  )
  @Builder.Default
  private SortOrder sortOrder = SortOrder.DESC;

}
