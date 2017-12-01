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
@ApiModel(description = "Contains pagination fields for search requests")
public class PaginationDTO implements Serializable {
  private static final long serialVersionUID = 1558540231669981014L;

  @ApiModelProperty(
      value = "Number of search result page when result is divided in pages. Default value is 0.",
      example = "0"
  )
  @Builder.Default
  private Short pageNumber = 0;

  @ApiModelProperty(
      value = "Size of search result page when result is divided in pages. Default value is 0 which "
          + "means result is not divided in pages and will be returned entirely.",
      example = "2"
  )
  @Builder.Default
  private Short pageSize = 0;
}
