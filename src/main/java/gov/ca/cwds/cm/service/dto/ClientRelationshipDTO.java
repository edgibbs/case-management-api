package gov.ca.cwds.cm.service.dto;

import static gov.ca.cwds.data.persistence.cms.CmsPersistentObject.CMS_ID_LEN;
import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

import com.fasterxml.jackson.annotation.JsonFormat;
import gov.ca.cwds.cm.RequestResponse;
import io.dropwizard.validation.OneOf;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClientRelationshipDTO extends BaseDTO implements RequestResponse {

  private static final long serialVersionUID = 7455548566030460582L;

  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "ID. String of size 10.", example = "AcB3Wu00Rx")
  private String relationshipId;

  @NotNull
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(value = "Client ID. String of size 10.", example = "FplTfDs0Rx", required = true)
  private String clientId;

  @NotNull
  @ApiModelProperty(
      value = "Client relationship role name. String.", example = "Son", required = true
  )
  private String clientRelationshipRole;

  @NotNull
  @Size(min = CMS_ID_LEN, max = CMS_ID_LEN)
  @ApiModelProperty(
      value = "Related Client ID. String of size 10.", example = "MHH2zjk0Rx", required = true
  )
  private String relatedClientId;

  @NotNull
  @ApiModelProperty(
      value = "Related client relationship role name. String.", example = "Father", required = true
  )
  private String relatedClientRelationshipRole;

  @NotNull
  @Size(max = Short.MAX_VALUE)
  @ApiModelProperty(value = "System ID of the relationship type. Numeric.", example = "285", required = true)
  private Short relationshipTypeCode;

  @NotNull
  @ApiModelProperty(
      value = "Indicates if the parent client is absent for the related child client. Boolean.",
      example = "false",
      required = true
  )
  private Boolean absentParentIndicator;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(
      value = "The date the relationship began.",
      example = "2000-10-20"
  )
  private LocalDate relationshipStartDate;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @ApiModelProperty(
      value = "The date the relationship ended.",
      example = "2018-10-20"
  )
  private LocalDate relationshipEndDate;

  @NotNull
  @OneOf(
      value = {"NO", "UNKNOWN", "YES"},
      ignoreCase = true,
      ignoreWhitespace = true
  )
  @ApiModelProperty(
      required = true,
      value = "Indicates whether the two CLIENTs live in the same home , permitted values are : 'NO', 'UNKNOWN', 'YES'",
      example = "YES"
  )
  private String sameHomeStatus;


}
