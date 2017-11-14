package gov.ca.cwds.cm.service.dto;

import gov.ca.cwds.rest.api.Response;
import io.dropwizard.jackson.JsonSnakeCase;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author CWDS TPT-3 Team
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonSnakeCase
public class AddressDTO extends BaseDTO implements Response {

  private static final long serialVersionUID = 1L;

  @ApiModelProperty(
      name = "id",
      value = "id",
      notes = "ID - A system generated number used to uniquely identify each ADDRESS. This ID is "
          + "composed of a base 62 Creation Timestamp and the STAFF_PERSON ID (a sequential 3 "
          + "digit base 62 number generated by the system). This value eliminates the need for "
          + "an additional set of Creation Timestamp and Creation User ID which is needed to satisfy "
          + "the Audit Trail requirement.",
      example = "AaQshqm0Mb"
  )
  private String id;

  @ApiModelProperty(
      name = "description",
      value = "Address Description",
      notes = "DESCRIPTION - Any additional information pertaining to the  ADDRESS which may "
          + "include directions for getting  to the ADDRESS, description of the residence, or "
          + "foreign phone number, as well as the name and hours (e.g., 3pm to 6pm) of the day care "
          + "for the child CLIENT who is at the day care center. If the correspondent ADDRESS TYPE "
          + "value for this  ADDRESS is 'Homeless', the location of where the  CLIENT lives must "
          + "be enter here (e.g., shelter care).",
      example = "Third street on the left"
  )
  private String description;

  @ApiModelProperty(
      name = "city",
      value = "City",
      notes = "CITY_NAME - The name of the city for the ADDRESS.",
      example = "Sacramento"
  )
  private String city;

  @ApiModelProperty(
      name = "emergency_phone",
      value = "Emergency Phone",
      notes = "EMERGENCY_PHONE_NUMBER - An alternate or emergency phone number for the CLIENT.",
      example = "9168765876"
  )
  private String emergencyPhone;

  @ApiModelProperty(
      name = "emergency_phone_extension",
      value = "Emergency Phone Extension",
      notes = "EMERGENCY_PHONE_EXTENSION_NUMBER - The emergency phone extension number of the CLIENT.",
      example = "523523"
  )
  private String emergencyPhoneExtension;

  @ApiModelProperty(
      name = "foreign_address_exists",
      value = "Foreign Address Exists",
      notes = "FOREIGN_ADDRESS_IND_VAR - This indicator variable is used to indicate if there are "
          + "any occurrences of FOREIGN_ADDRESSs related to this ADDRESS. This will save unnecessary "
          + "processing time from searching for information that does not exist in the database.",
      example = "false"
  )
  private Boolean foreignAddressExists;

  @ApiModelProperty(
      name = "government_entity_type_code",
      value = "Government Entity Type Code",
      notes = "GOVERNMENT_ENTITY_TYPE - The system generated number which represents the  specific "
          + "county (e.g., Napa, Sacramento, Fresno,  etc.) within the state of California for a "
          + "specific CLIENT's ADDRESS. "
          + "Additional info can be reached via dictionaries resource by 'GVR_ENTC' key.",
      example = "1070"
  )
  private Short governmentEntityCode;

  @ApiModelProperty(
      name = "message_phone",
      value = "Message Phone",
      notes = "MESSAGE_PHONE_NUMBER - An alternate or message phone number for the CLIENT.",
      example = "9163452435"
  )
  private String messagePhone;

  @ApiModelProperty(
      name = "message_phone_extension",
      value = "Message Phone Extension",
      notes = "MESSAGE_PHONE_EXTENSION_NUMBER - The message phone extension number of the CLIENT.",
      example = "1234"
  )
  private String messagePhoneExtension;

  @ApiModelProperty(
      name = "other_header_address",
      value = "Other Header Address",
      notes = "OTHER_HEADER_ADDRESS - Any additional address information which will be placed above "
          + "the standard postal Delivery Address Line. This may include the name of the In Care Of "
          + "person, firm, institution or building to which the piece of mail is directed.",
      example = "PO Box 901234"
  )
  private String otherHeaderAddress;

  @ApiModelProperty(
      name = "post_direction_text_code",
      value = "Post Direction Text Code",
      notes = "POST_DIRECTION_TEXT_CODE - The two-letter postal abbreviation following the Street "
          + "Name and Street Suffix which gives directional information about a specific CLIENT's "
          + "ADDRESS for delivery purposes. For example NE (Northeast), SW (Southwest), etc.",
      example = "SW"
  )
  private String postDirectionTextCode;

  @ApiModelProperty(
      name = "pre_direction_text_code",
      value = "Pre Direction Text Code",
      notes = "PRE_DIRECTION_TEXT_CODE - The two-letter postal abbreviation preceding the Street "
          + "Name and Street Suffix which gives directional information about a specific CLIENT's "
          + "ADDRESS for delivery purposes. For example NE (Northeast), SW (Southwest), etc.",
      example = "NE"
  )
  private String preDirectionTextCode;

  @ApiModelProperty(
      name = "primary_phone",
      value = "Primary Phone",
      notes = "PRIMARY_PHONE_NUMBER - The primary phone number including area code of the CLIENT.",
      example = "9167654321"
  )
  private String primaryPhone;

  @ApiModelProperty(
      name = "primary_phone_extension",
      value = "Primary Phone Extension",
      notes = "PRIMARY_PHONE_EXTENSION_NUMBER - The primary phone extension number of the CLIENT.",
      example = "4321"
  )
  private String primaryPhoneExtension;

  @ApiModelProperty(
      name = "state_code",
      value = "State Code",
      notes = "STATE_CODE_TYPE - The system generated number which identifies the State for a "
          + "specific CLIENT's ADDRESS (e.g. California, Hawaii, Texas, etc). "
          + "Additional info can be reached via dictionaries resource by 'STATE_C' key.",
      example = "1828"
  )
  private Short stateCode;

  @ApiModelProperty(
      name = "street_name",
      value = "Street Name",
      notes = "STREET_NAME - The actual name of the street associated with a specific "
          + "CLIENT's ADDRESS. Do not abbreviate if at all possible for matching purposes.",
      example = "Coleman Road"
  )
  private String streetName;

  @ApiModelProperty(
      name = "street_number",
      value = "Street Number",
      notes = "STREET_NUMBER - The street or house number associated with the street name as part "
          + "of the ADDRESS. This may include the fractional or alphabetic modifier "
          + "(e.g. A-17, 119-10, 39.2, 100 1/2, etc).",
      example = "100 1/2"
  )
  private String streetNumber;

  @ApiModelProperty(
      name = "street_suffix_code",
      value = "Street Suffix Code",
      notes = "STREET_SUFFIX_TYPE - The system generated number assigned to each postal standard "
          + "abbreviation following the Street Name which further identifies the uniqueness "
          + "of the ADDRESS. E.g. Road, Plaza, Square, etc. "
          + "Additional info can be reached via dictionaries resource by 'ST_SFX_C' key.",
      example = "1988"
  )
  private Short streetSuffixCode;

  @ApiModelProperty(
      name = "unit_designator_code",
      value = "Unit Designator Code",
      notes = "UNIT_DESIGNATOR_TYPE - The system generated number assigned for each standard postal "
          + "abbreviation which further defines the location of a specific CLIENT's ADDRESS "
          + "(e.g. APT (Apartment), BLDG (Building), FL (floor), etc)."
          + "Additional info can be reached via dictionaries resource by 'UNT_DSGC' key.",
      example = "2066"
  )
  private Short unitDesignatorCode;

  @ApiModelProperty(
      name = "unit_number",
      value = "Unit Number",
      notes = "UNIT_NUMBER - The actual alphanumeric ID following the standard postal abbreviation "
          + "(UNIT DESIGNATOR) which further defines the position of ADDRESS (e.g. 200A, 2C, etc).",
      example = "301"
  )
  private String unitNumber;

  @ApiModelProperty(
      name = "zip",
      value = "Zip",
      notes = "ZIP_NUMBER - The first five digits of the zip code for ADDRESS.",
      example = "95834"
  )
  private String zip;

  @ApiModelProperty(
      name = "zip_suffix",
      value = "Zip Suffix",
      notes = "ZIP_SUFFIX_NUMBER - The last four digits of the zip code for an ADDRESS.",
      example = "4321"
  )
  private String zipSuffix;


}
