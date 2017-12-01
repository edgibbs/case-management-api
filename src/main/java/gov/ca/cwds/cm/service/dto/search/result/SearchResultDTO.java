package gov.ca.cwds.cm.service.dto.search.result;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dto.BaseDTO;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The abstract class purpose is to support swagger ApiModel description for concrete search result.
 * The class to be extended by concrete DTO search result e.g. SearchResultDTO<CaseDTO>.
 *
 * @author CWDS TPT-3 Team
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"messages"})
@SuppressWarnings({"squid:S1948"})
public abstract class SearchResultDTO<T extends BaseDTO> implements Response {

  private static final long serialVersionUID = 7432526465895154901L;

  @ApiModelProperty(value = "Collection of result items that match requested search criteria")
  private Collection<T> results = new ArrayList<>();

  @ApiModelProperty(
      value = "Total records amount that can be found by requested search criteria",
      example = "95638"
  )
  private Long totalRecords = 0L;

}
