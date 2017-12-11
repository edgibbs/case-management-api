package gov.ca.cwds.cm.service.dto.facade;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.cm.service.dto.BaseDTO;
import gov.ca.cwds.data.legacy.cms.entity.enums.AssignmentType;
import gov.ca.cwds.rest.api.Response;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author CWDS TPT-3 Team
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(description = "Representation of CASE, CLIENT and ASSIGNMENT in a single object")
public class CaseByStaff extends BaseDTO implements Response {

  private static final long serialVersionUID = 2291810953375769220L;

  @ApiModelProperty(
      value = "CASE.ID - The system generated unique identifier for each CASE. Although each CASE "
          + "can be uniquely identified by a CLIENT and the CASE Start Date, an ID will allow "
          + "STAFF_PERSONs to quickly reference existing CASEs. It will also help preserve confidentiality "
          + "by not making it necessary to reference a child's name to identify a CASE. This ID has "
          + "an internal 10 digit alpha-numeric representation and an external 19 digit numeric "
          + "representation. The external representation is displayed at the User Interface or on "
          + "Reports and Documents in the following format: 1234-1234-1234-1234567. The inclusion "
          + "of the hyphens used in the formatting of this string results in a 22 byte display area. "
          + "This ID is composed of the concatenation of a Creation Timestamp and the STAFF_PERSON ID. "
          + "This value eliminates the need for an additional set of Creation Timestamp and "
          + "Creation User ID which is needed to satisfy the Audit Trail requirement. The Creation "
          + "Timestamp is a 'bit-shifted' timestamp representation which provides up to 1/100 of a "
          + "second time granularity. The Timestamp uses a two digit internal year representation. "
          + "An algorithm which generates a user displayable Timestamp value is provided which generates "
          + "the century based upon the year value. When the year is less than 55, a value of 2000 "
          + "is added, otherwise a value of 1900 is added as the century. The STAFF_PERSON ID is a "
          + "sequential 3 digit base 62 number generated by the system. The STAFF_PERSON ID (3 bytes) "
          + "is appended to the 7 digit internal timestamp value to provide the final 10 byte result.",
      example = "AaQshqm0Mb"
  )
  private String identifier;

  @ApiModelProperty(
      value = "CLIENT.ID - A system generated number used to uniquely identify each CLIENT. "
          + "This ID has an internal 10 digit alpha-numeric representation[sic] and an external 19 "
          + "digit numeric representation.  The external representation is displayed at the User "
          + "Interface or on Reports and Documents in the following format: 1234-1234-1234-1234567. "
          + "The inclusion of the hyphens used in the formatting of this string results in a 22 byte "
          + "display area. This ID is composed of the concatenation of a Creation Timestamp and "
          + "the STAFF PERSON ID.  This value eliminates the need for an additional set of Creation "
          + "Timestamp and Creation User ID which is needed to satisfy the Audit Trail requirement. "
          + "The Creation Timestamp is a 'bit-shifted' timestamp representation which provides up "
          + "to 1/100 of a second time granularity.  The Timestamp uses a two digit internal year "
          + "representation. An algorithm which generates a user displayable Timestamp value is "
          + "provided which generates the century  based upon the year value. When the year is less than "
          + "55,  a value of 2000 is added, otherwise a value of 1900 is added as the century. "
          + "The Staff Person ID is a  sequential 3 digit base 62 number generated by the system. "
          + "The Staff Person ID (3 bytes) is  appended to the 7 digit internal timestamp value to "
          + "provide the final 10 byte result.",
      example = "Gdlhhri0Ki"
  )
  private String clientIdentifier;

  @ApiModelProperty(
      value = "CLIENT.COMMON_FIRST_NAME - The first name commonly used to refer to a CLIENT. "
          + "This is not necessarily the CLIENT's legal name, it is simply the name by which the "
          + "CLIENT is referred to by family members, friends, and CWS staff.",
      example = "Alexander"
  )
  private String clientFirstName;

  @ApiModelProperty(
      value = "CLIENT.COMMON_LAST_NAME - The last name commonly used to refer to a CLIENT. "
          + "This is not necessarily the CLIENT's legal name, it is simply the name by which the "
          + "CLIENT is referred to by family members, friends, and CWS staff.",
      example = "Brownhall"
  )
  private String clientLastName;

  @ApiModelProperty(
      value = "CASE.ACTIVE_SERVICE_COMPONENT_TYPE - The system generated number assigned for each "
          + "type of service component being referenced  for a child's CASE (e.g., Emergency Response, "
          + "Family Maintenance, Family Reunification, Permanent Placement).",
      example = "Family Reunification"
  )
  private String activeServiceComponent;

  @ApiModelProperty(
      value = "ASSIGNMENT.TYPE_OF_ASSIGNMENT_CODE - This indicator specifies who has the lead role "
          + "in carrying out the responsibilities of the CASE or REFERRAL. The primary assignment "
          + "can be made to either the case working STAFF_PERSON or to an OUT_OF_STATE_CONTACT_PARTY. "
          + "There may be many ASSIGNMENTs considered to be 'primary' over the life of the CASE "
          + "or REFERRAL, but only one of them is current at any time. An ASSIGNMENT can be either "
          + "designated as Primary (P), Secondary (S), or Read Only (R). Primary assigned workers "
          + "have the capability to retrieve, read, and update any case or referral to which they "
          + "have direct or indirect assignment. Similarly, Secondary assigned workers also have "
          + "the same capabilities to retrieve, read, and update any case or referral to which they "
          + "ave direct or indirect assignment. In fact, Secondary workers for the most part have "
          + "the same capabilities as the Primary worker, but occasionally there are business rules "
          + "in the application which prohibit the Secondary worker from doing something that the "
          + "Primary worker can do (i.e. requesting the closure of an Adoptions Case). Read Only "
          + "assigned workers have the capability to access and read any case or referral to which "
          + "they have direct or indirect assignment, but they do not have update capability.",
      allowableValues = "PRIMARY, SECONDARY, READ_ONLY",
      example = "PRIMARY"
  )
  private AssignmentType assignmentType;

}
