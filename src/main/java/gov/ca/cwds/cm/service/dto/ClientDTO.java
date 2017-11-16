package gov.ca.cwds.cm.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import gov.ca.cwds.rest.validation.Date;
import io.dropwizard.validation.OneOf;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.LocalDate;

import static gov.ca.cwds.rest.api.domain.DomainObject.DATE_FORMAT;

/** @author CWDS TPT-3 Team */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ClientDTO extends BaseDTO {

  private static final long serialVersionUID = -4098613951159302301L;

  @NotNull
  @Size(max = 10)
  @ApiModelProperty(
    value =
        "ID - A system generated number used to uniquely  identify each CLIENT.    This ID has an internal "
            + "10 digit alpha-numeric and an external 19 digit numeric representation.",
    example = "0YIPkZU0S0"
  )
  private String identifier;

  @NotNull
  @Size(max = 1)
  @OneOf(
    value = {"N", "T", "P", "A"},
    ignoreCase = true,
    ignoreWhitespace = true
  )
  @ApiModelProperty(
    value =
        "ADOPTION STATUS CODE - Indicates whether a child CLIENT is \"totally\" free (T), or \"partially\" free (P),"
            + " \"not free\" (N), or \"Not Applicable (A) from all parents.  This indicator will simplify the SOC 158"
            + " reporting process.  However, this is a user maintain attribute and it may not be up-to-date at all "
            + "time.",
    example = "N"
  )
  private String adptnStcd;

  @NotNull
  @ApiModelProperty(
    value =
        "ALIEN REGISTRATION NUMBER - A unique identification number issued by the INS for each person with a "
            + "non-citizen status",
    example = "111483672"
  )
  private String alnRegNo;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @Date(format = DATE_FORMAT)
  @ApiModelProperty(value = "BIRTH_DATE - Date of birth of the CLIENT.", example = "1944-01-30")
  private LocalDate birthDt;

  @NotNull
  @ApiModelProperty(
    value = "BIRTH FACILITY NAME - The name of the facility where the CLIENT was born.",
    example = "San Jose Medical Center"
  )
  private String brFacNm;

  @NotNull
  @ApiModelProperty(
    value = "BIRTH FACILITY NAME - The name of the facility where the CLIENT was born.",
    example = "San Jose Medical Center"
  )
  private Short bStateC;

  @NotNull
  @ApiModelProperty(
    value =
        "BIRTH STATE CODE TYPE - The system number which identifies the State where the CLIENT "
            + "was born (e.g., California, Hawaii, Texas, etc.).",
    example = "1828"
  )
  private Short bCntryC;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "CHILD CLIENT IND VAR - This indicator variable is used to indicate if there are any "
            + "occurrences of CHILD CLIENTs related to this CLIENT.    This will save unnecessary "
            + "processing time from  searching for information that does not exist in the data base.",
    example = "N"
  )
  private String chldCltB;

  @Size(max = 20)
  @NotNull
  @ApiModelProperty(
    value =
        "COMMON FIRST NAME - The first name commonly used to refer to a CLIENT. This is not necessarily "
            + "the CLIENT's legal name, it is simply the name by which the CLIENT is referred to by "
            + "family members, friends, and CWS staff.",
    example = "Monica"
  )
  private String comFstNm;

  @Size(max = 25)
  @NotNull
  @ApiModelProperty(
    value =
        "CCOMMON LAST NAME - The last name commonly used to refer to a CLIENT.  This is not necessarily "
            + "the CLIENT's legal name, it is simply the name by which the CLIENT is referred to by "
            + "family members, friends, and CWS staff.",
    example = "Pain"
  )
  private String comLstNm;

  @Size(max = 20)
  @NotNull
  @ApiModelProperty(
    value =
        "COMMON MIDDLE NAME - The middle name commonly used to refer to a CLIENT.  This is not "
            + "necessarily the CLIENT's legal name, it is simply the name by which the CLIENT is "
            + "referred to by family members, friends, and CWS staff.",
    example = "Jacobson"
  )
  private String comMidNm;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "CONFIDENTIALITY IN EFFECT IND - The date that confidentiality goes into effect or is no longer "
            + "in effect for a CLIENT.  This may include the date that a Non Disclosure Order is "
            + "granted, denied, or rescinded, but does not always have to be initiated by a "
            + "Non Disclosure Order request.",
    example = "N"
  )
  private String confEfind;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value =
        "CONFIDENTIALITY ACTION DATE - This indicates whether or not confidentiality is currently in effect for "
            + "this CLIENT. The confidentiality may be a result of a non disclosure order, or a social worker's "
            + "judgment call on an individual case to protect a CLIENT.",
    example = "2004-06-14"
  )
  private LocalDate confActdt;

  @NotNull
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value =
        "CREATION DATE - The date when a new client entry is entered into the CWS system.  "
            + "This should be defaulted to the system date.",
    example = "1999-08-15"
  )
  private LocalDate creatnDt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @Date(format = DATE_FORMAT)
  @ApiModelProperty(value = "DEATH_DATE - The date the CLIENT passed away.", example = "1999-08-15")
  private LocalDate deathDt;

  @Size(max = 10)
  @ApiModelProperty(
    value =
        "DEATH_REASON_TEXT - Cause of death for the CLIENT.  This is the ID from the LONG TEXT entity "
            + "type which uniquely identifies a specific occurrence of user defined text.",
    example = "U8SxGBF00c"
  )
  private String dthRnTxt;

  @NotNull
  @Size(max = 20)
  @ApiModelProperty(
    value = "DRIVER_LICENSE_NUMBER - The driver license number of the CLIENT.",
    example = "987654321"
  )
  private String drvLicNo;

  @NotNull
  @ApiModelProperty(
    value =
        "DRIVER LICENSE STATE CODE TYPE - The system generated number which identifies the State where "
            + "the CLIENT's Driver License was issued (e.g. California, Hawaii, Texas, etc).",
    example = "1828"
  )
  private Short dStateC;

  @NotNull
  @ApiModelProperty(
    value =
        "GENDER_CODE - Indicates the gender of a CLIENT (e.g. F = female, M = male, U = unknown, etc).",
    example = "M"
  )
  private String genderCd;

  @NotNull
  @ApiModelProperty(
    value =
        "IMMIGRATION COUNTRY CODE TYPE - The system generated number which identifies the  Country of "
            + "origin for a specific CLIENT (e.g., United States, China, Mexico, etc.).",
    example = "563"
  )
  private Short iCntryC;

  @NotNull
  @ApiModelProperty(
    value =
        "IMMIGRATION STATUS TYPE - The system generated number which identifies the type of residency "
            + "status for the CLIENT (e.g., refugee, alien, or US citizen, etc.).",
    example = "1199"
  )
  private Short imgtStc;

  @Size(max = 2)
  @NotNull
  @ApiModelProperty(
    value =
        "INCAPACITATED PARENT CODE - This indicates if the parent CLIENT is incapacitated.  This "
            + "information is passed along to the eligibility worker when determining eligibility of "
            + "the child for federal aid.",
    example = "1199"
  )
  private String incapcCd;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "LITERATE_CODE - Indicates whether the CLIENT is in his or her primary language literate (Y), "
            + "illiterate (N), or the social worker doesn't know for sure (U), "
            + "or it is not applicable (D).",
    example = "N"
  )
  private String litrateCd;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "MARITAL COHABITATN HSTRY IND VAR - This indicator variable is used to indicate if there are any "
            + "occurrences of MARITAL COHABITATION HISTORY related to this CLIENT.    "
            + "This will save unnecessary processing time from  searching for information that "
            + "does not exist in the data base.",
    example = "N"
  )
  private String marHistB;

  @NotNull
  @ApiModelProperty(
    value =
        "MARITAL STATUS TYPE - The system generated number which identifies the type of marital status for "
            + "the CLIENT (e.g., single, married, divorced, etc.).",
    example = "1308"
  )
  private Short mrtlStc;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "MILITARY STATUS CODE - This indicates whether a child CLIENT is military dependent (D), or an "
            + "adult CLIENT is military active (A), or an adult CLIENT is a veteran (V), or the CLIENT "
            + "has no military involvement (N), or no information are available (U).",
    example = "U"
  )
  private String miltStacd;

  @Size(max = 6)
  @NotNull
  @ApiModelProperty(
    value =
        "NAME PREFIX DESCRIPTION - The salutation form to be used in the mailing address of a "
            + "CLIENT (e.g., Mr., Ms., Mrs., Dr., Miss, Rev., etc.).",
    example = "Mr"
  )
  private String nmprfxDsc;

  @NotNull
  @ApiModelProperty(
    value =
        "NAME TYPE - The system generated number which identifies the type of NAME "
            + "for a CLIENT (e.g., legal, AKA, etc.).",
    example = "1313"
  )
  private Short nameTpc;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "OUTSTANDING_WARRANT_IND - Indicates whether there is an outstanding warrant "
            + "for this particular child (Y) or not (N).",
    example = "Y"
  )
  private String outwrtInd;

  @NotNull
  @ApiModelProperty(
    value =
        "PRIMARY ETHNICITY TYPE - The system generated number which identifies the  primary "
            + "ethnicity for the CLIENT (e.g., Native  American, Asian, Hispanic, Black, etc.).",
    example = "841"
  )
  private Short pEthnctyc;

  @NotNull
  @ApiModelProperty(
    value =
        "PRIMARY LANGUAGE TYPE - The system generated number which identifies the  primary language "
            + "spoken by a specific CLIENT (e.g., English, Spanish, Chinese, etc.).",
    example = "33"
  )
  private Short pLangTpc;

  @NotNull
  @ApiModelProperty(
    value =
        "RELIGION TYPE - The system generated number which identifies the  specific religion group the "
            + "CLIENT is affiliated with (e.g., Baptist, Christian, Jewish, etc.).",
    example = "33"
  )
  private Short rlgnTpc;

  @NotNull
  @ApiModelProperty(
    value =
        "SECONDARY LANGUAGE TYPE - The system generated number which identifies the  secondary language "
            + "spoken by a specific CLIENT (e.g., English, Spanish, Chinese, etc.).",
    example = "N"
  )
  private Short sLangTc;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "SENSITIVITY INDICATOR - This indicates whether or not the associated information for this CLIENT "
            + "is sensitive.  This means that for various reasons information about this client is "
            + "restricted to authorized individuals only.",
    example = "12"
  )
  private String senstvInd;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value =
        "SENSITIVE HLTH INFO ON FILE IND - Indicates whether sensitive health information is being stored "
            + "in a social worker's file rather than on the system.",
    example = "NSENSTV_IND"
  )
  private String sntvHlind;

  @Size(max = 9)
  @NotNull
  @ApiModelProperty(
    value = "SOCIAL_SECURITY_NUMBER - The Social Security Number for the CLIENT.",
    example = "111-111-1111"
  )
  private String ssNo;

  @Size(max = 1)
  @NotNull
  @ApiModelProperty(
    value = "SOCIAL SECURITY NUM CHANGED CODE - This is an unused attribute. The default is N.",
    example = "N"
  )
  private String ssnChgCd;

  @Size(max = 4)
  @NotNull
  @ApiModelProperty(
    value =
        "SUFFIX TITLE DESCRIPTION - The suffix name of a CLIENT (e.g., Esq., M.D., Ph.D., D.D.S., etc.).",
    example = "D.D.S."
  )
  private String sufxTldsc;

  @Size(max = 2)
  @NotNull
  @ApiModelProperty(
    value =
        "UNEMPLOYED PARENT CODE - This indicates if the parent CLIENT is unemployed.  This information "
            + "is passed along to the eligibility worker when determining eligibility of "
            + "the child for federal aid.",
    example = "U"
  )
  private String unemplyCd;

  @NotNull
  @ApiModelProperty(
    value =
        "LAST UPDATE ID - The ID (a sequential 3 digit base 62 number generated by the system) of the "
            + "STAFF PERSON or batch program which made the last update to an occurrence of "
            + "this entity type.",
    example = "2004-08-10 08:07:07.752386"
  )
  private String lstUpdId;

  @NotNull
  @ApiModelProperty(
    value =
        "LAST UPDATE TIMESTAMP - The time and date of the most recent update to an "
            + "occurrence of this entity type.",
    example = "00h"
  )
  private Timestamp lstUpdTs;

  @NotNull
  @Size(max = 120)
  @ApiModelProperty(
    value =
        "COMMENT DESCRIPTION - A brief description of any unusual circumstances  concerning the CLIENT "
            + "which can not be captured  through the CLIENT CONDITION entity type. "
            + " (e.g., communication difficulty, special religion practices, or any other relevant "
            + "information which could be used in planning services for the CLIENT).",
    example = "Primary Comments for the Primary Client."
  )
  private String commntDsc;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "ESTIMATED DOB CODE - Indicates if the date of birth in the CLIENT entity is estimated (Y) or "
            + "if a birth date was actually entered (N) or has not been provided (U).",
    example = "Y"
  )
  private String estDobCd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "BIRTHPLACE VERIFIED IND - Records that the birthplace of the client has been verified by "
            + "means of a birth certificate or other legal document acceptable to the court.",
    example = "N"
  )
  private String bpVerInd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "HISPANIC ORIGIN CODE - Records Hispanic origin of the individual client. An 'X' indicates no user "
            + "selection has been made.",
    example = "U"
  )
  private String hispCd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "CURR CA CHILDREN SERV IND - This indicator tells the worker if the child was receiving care "
            + "from a California Children Services center. With Release 6.8, this attribute and the "
            + "data contained within are historical, and new values will be stored in "
            + "the DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = "N"
  )
  private String currcaInd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "CURRENTLY REGIONAL CENTER IND - This indicator tells the worker if the child was receiving care "
            + "from a Regional Center. With Release 6.8, this attribute and the data contained within "
            + "are historical, and new valueswill be stored in the DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = "Y"
  )
  private String curregInd;

  @NotNull
  @Size(max = 25)
  @ApiModelProperty(
    value =
        "CURRENTLY OTHER DESCRIPTION - This is a description of where the child was receiving care when "
            + "it is not a CA Children Services Center or Regional Center. With Release 6.8, this "
            + "attribute and the data contained within are historical, and new values will be stored "
            + "in the DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = "QWREQWER"
  )
  private String cothDesc;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "PREV CA CHILDREN SERV IND - This indicator tells the worker if the child has previously "
            + "received care from a California Children Services center. With Release 6.8, "
            + "this attribute and the data contained within are historical, and new values will "
            + "be stored in the DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = "N"
  )
  private String prevcaInd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "PREV REGIONAL CENTER IND   - This indicator tells the worker if the child has previously "
            + "received care from a Regional Center. With Release 6.8, this attribute and the data "
            + "contained within are historical, and new values will be stored in the "
            + "DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = "N"
  )
  private String preregInd;

  @NotNull
  @Size(max = 25)
  @ApiModelProperty(
    value =
        "PREV OTHER DESCRIPTION  - This is a description of where the child has been previously"
            + "receiving care when it is not a CA Children Services Center or Regional Center. With "
            + "Release 6.8, this attribute and the data contained within are historical, and new values "
            + "will be stored in the DUAL_AGENCY_SERVICES_HISTORY entity.",
    example = " "
  )
  private String pothDesc;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "INDIVIDUAL HEALTH CARE PLAN IND - This indicator tells the worker that there is an Individual "
            + "Health Care Plan  on File for a Special Needs Child.",
    example = "N"
  )
  private String hcareInd;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "LIMITATION ON SCP HEALTH IND - This indicator tells the worker that there is a limitation put on "
            + "Substitute Care Provider's Ability to make Health Care Decisions for this child.",
    example = "N"
  )
  private String limitInd;

  @NotNull
  @Size(max = 35)
  @ApiModelProperty(
    value = "BIRTH CITY - The name of the city or reservation where the CLIENT was born.",
    example = "San Jose"
  )
  private String birthCity;

  @Size(max = 10)
  @ApiModelProperty(
    value =
        "HEALTH SUMMARY TEXT - A brief description of a CLIENT's overall health condition and/or "
            + "information about the location of a CHILD CLIENT's health records.  This is the ID from the LONG "
            + "TEXT entity type which uniquely identifies a specific occurrence of user defined text.",
    example = "0Wqj8l901w"
  )
  private String healthTxt;

  @ApiModelProperty(
    value =
        "MOTHER PARENTAL RIGHT TERM DATE - The date the mothers parental rights were terminated.  "
            + "This is only used by placement episodes created in the SOC158 application. "
            + "The Agency Responsible Types for these episodes include - County Probation Department, "
            + "Indian Child Welfare, Out of State Agency, Private Adoption Agency, and State Adoptions "
            + "District Office.",
    example = " "
  )
  private LocalDate mtermDt;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
  @Date(format = DATE_FORMAT)
  @ApiModelProperty(
    value =
        "FATHER_PARENTAL_RIGHT_TERM_DATE - The date the father's parental rights were terminated. "
            + "This is only used by placement episodes created in the SOC158 application. The Agency"
            + "Responsible Types for these episodes include - County Probation Department, Indian Child Welfare"
            + ", Out of State Agency, Private Adoption Agency, and State Adoptions District Office.",
    example = "1999-08-15"
  )
  private LocalDate ftermDt;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "ZIPPY_CREATED_IND - Indicates whether or not this CLIENT was created from within the Zippy "
            + "Referral notebook as opposed to the traditional client notebook.",
    example = "N"
  )
  private String zippyInd;

  @Size(max = 35)
  @ApiModelProperty(
    value = "DEATH_PLACE - The place of death for the CLIENT.",
    example = "San Jose"
  )
  private String deathPlc;

  @Size(max = 1)
  @ApiModelProperty(
    value =
        "TRIBAL_MEMBRSHP_VERIFCTN_IND_VAR - This indicator variable is used to indicate if there are "
            + "any occurrences of TRIBAL MEMBERSHIP VERIFICATIONs related to this CLIENT. This will save "
            + "unnecessary processing time from searching for information that does not exist in the data base.",
    example = "N"
  )
  private String trMbvrtB;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "TRIBAL_ANCESTRY_CLIENT_IND_VAR - This indicator variable is used to indicate if there are any "
            + "occurrences of TRIBAL ANCESTRY CLIENT related to this CLIENT. This will save "
            + "unnecessary processing time from searching for information that does "
            + "not exist in the data base.",
    example = "N"
  )
  private String trbaCltB;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "SOC158_SEALED_CLIENT_IND - This indicates whether or not the client's record has been sealed "
            + "in the SOC 158 application. The valid values are Yes (Y), No (N).",
    example = "Y"
  )
  private String soc158Ind;

  @NotNull
  @Size(max = 1)
  @ApiModelProperty(
    value =
        "DEATH_DATE_VERIFIED_IND - This indicates whether the date of death has been verified. "
            + "The valid values are Yes (Y) and No (N)",
    example = "N"
  )
  private String dthDtInd;

  @Size(max = 50)
  @ApiModelProperty(
    value = "EMAIL_ADDRESS - The e-mail address for the CLIENT.",
    example = "test@test.com"
  )
  private String emailAddr;

  @Size(max = 1)
  @ApiModelProperty(
    value = "ADJUDICATED DELINQUENT IND - Records that a client has been an adjudicated delinquent",
    example = " "
  )
  private String adjdelInd;

  @Size(max = 1)
  @ApiModelProperty(
    value =
        "ETH UNABLE TO DET REASON CODE - Records the reason that 'Unable to Determine' was selected as "
            + "the Race/Ethnicity for an individual client.",
    example = ""
  )
  private String ethUdCd;

  @Size(max = 1)
  @ApiModelProperty(
    value =
        "HISP UNABLE TO DET REASON CODE - Records the reason that 'Unable to Determine' was selected as "
            + "the Hispanic or Latino Origin for an individual client.",
    example = " "
  )
  private String hispUdCd;

  @Size(max = 1)
  @ApiModelProperty(
    value =
        "SOC_158_PLACEMENT_CODE - This code represents whether the CLIENT has placements that were "
            + "created in the SOC 158 application (Y), has SOC 158 application-created placements that "
            + "were migrated to the Client Services application (M), or does not have any placements "
            + "that were created in the SOC 158 application (N).",
    example = "M"
  )
  private String socplcCd;

  @Size(max = 12)
  @ApiModelProperty(
    value = "This number is assigned by the Statewide Client Index (SCI).",
    example = " "
  )
  private String clIndxNo;

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

  public String getAdptnStcd() {
    return adptnStcd;
  }

  public void setAdptnStcd(String adptnStcd) {
    this.adptnStcd = adptnStcd;
  }

  public String getAlnRegNo() {
    return alnRegNo;
  }

  public void setAlnRegNo(String alnRegNo) {
    this.alnRegNo = alnRegNo;
  }

  public LocalDate getBirthDt() {
    return birthDt;
  }

  public void setBirthDt(LocalDate birthDt) {
    this.birthDt = birthDt;
  }

  public String getBrFacNm() {
    return brFacNm;
  }

  public void setBrFacNm(String brFacNm) {
    this.brFacNm = brFacNm;
  }

  public Short getbStateC() {
    return bStateC;
  }

  public void setbStateC(Short bStateC) {
    this.bStateC = bStateC;
  }

  public Short getbCntryC() {
    return bCntryC;
  }

  public void setbCntryC(Short bCntryC) {
    this.bCntryC = bCntryC;
  }

  public String getChldCltB() {
    return chldCltB;
  }

  public void setChldCltB(String chldCltB) {
    this.chldCltB = chldCltB;
  }

  public String getComFstNm() {
    return comFstNm;
  }

  public void setComFstNm(String comFstNm) {
    this.comFstNm = comFstNm;
  }

  public String getComLstNm() {
    return comLstNm;
  }

  public void setComLstNm(String comLstNm) {
    this.comLstNm = comLstNm;
  }

  public String getComMidNm() {
    return comMidNm;
  }

  public void setComMidNm(String comMidNm) {
    this.comMidNm = comMidNm;
  }

  public String getConfEfind() {
    return confEfind;
  }

  public void setConfEfind(String confEfind) {
    this.confEfind = confEfind;
  }

  public LocalDate getConfActdt() {
    return confActdt;
  }

  public void setConfActdt(LocalDate confActdt) {
    this.confActdt = confActdt;
  }

  public LocalDate getCreatnDt() {
    return creatnDt;
  }

  public void setCreatnDt(LocalDate creatnDt) {
    this.creatnDt = creatnDt;
  }

  public LocalDate getDeathDt() {
    return deathDt;
  }

  public void setDeathDt(LocalDate deathDt) {
    this.deathDt = deathDt;
  }

  public String getDthRnTxt() {
    return dthRnTxt;
  }

  public void setDthRnTxt(String dthRnTxt) {
    this.dthRnTxt = dthRnTxt;
  }

  public String getDrvLicNo() {
    return drvLicNo;
  }

  public void setDrvLicNo(String drvLicNo) {
    this.drvLicNo = drvLicNo;
  }

  public Short getdStateC() {
    return dStateC;
  }

  public void setdStateC(Short dStateC) {
    this.dStateC = dStateC;
  }

  public String getGenderCd() {
    return genderCd;
  }

  public void setGenderCd(String genderCd) {
    this.genderCd = genderCd;
  }

  public Short getiCntryC() {
    return iCntryC;
  }

  public void setiCntryC(Short iCntryC) {
    this.iCntryC = iCntryC;
  }

  public Short getImgtStc() {
    return imgtStc;
  }

  public void setImgtStc(Short imgtStc) {
    this.imgtStc = imgtStc;
  }

  public String getIncapcCd() {
    return incapcCd;
  }

  public void setIncapcCd(String incapcCd) {
    this.incapcCd = incapcCd;
  }

  public String getLitrateCd() {
    return litrateCd;
  }

  public void setLitrateCd(String litrateCd) {
    this.litrateCd = litrateCd;
  }

  public String getMarHistB() {
    return marHistB;
  }

  public void setMarHistB(String marHistB) {
    this.marHistB = marHistB;
  }

  public Short getMrtlStc() {
    return mrtlStc;
  }

  public void setMrtlStc(Short mrtlStc) {
    this.mrtlStc = mrtlStc;
  }

  public String getMiltStacd() {
    return miltStacd;
  }

  public void setMiltStacd(String miltStacd) {
    this.miltStacd = miltStacd;
  }

  public String getNmprfxDsc() {
    return nmprfxDsc;
  }

  public void setNmprfxDsc(String nmprfxDsc) {
    this.nmprfxDsc = nmprfxDsc;
  }

  public Short getNameTpc() {
    return nameTpc;
  }

  public void setNameTpc(Short nameTpc) {
    this.nameTpc = nameTpc;
  }

  public String getOutwrtInd() {
    return outwrtInd;
  }

  public void setOutwrtInd(String outwrtInd) {
    this.outwrtInd = outwrtInd;
  }

  public Short getpEthnctyc() {
    return pEthnctyc;
  }

  public void setpEthnctyc(Short pEthnctyc) {
    this.pEthnctyc = pEthnctyc;
  }

  public Short getpLangTpc() {
    return pLangTpc;
  }

  public void setpLangTpc(Short pLangTpc) {
    this.pLangTpc = pLangTpc;
  }

  public Short getRlgnTpc() {
    return rlgnTpc;
  }

  public void setRlgnTpc(Short rlgnTpc) {
    this.rlgnTpc = rlgnTpc;
  }

  public Short getsLangTc() {
    return sLangTc;
  }

  public void setsLangTc(Short sLangTc) {
    this.sLangTc = sLangTc;
  }

  public String getSenstvInd() {
    return senstvInd;
  }

  public void setSenstvInd(String senstvInd) {
    this.senstvInd = senstvInd;
  }

  public String getSntvHlind() {
    return sntvHlind;
  }

  public void setSntvHlind(String sntvHlind) {
    this.sntvHlind = sntvHlind;
  }

  public String getSsNo() {
    return ssNo;
  }

  public void setSsNo(String ssNo) {
    this.ssNo = ssNo;
  }

  public String getSsnChgCd() {
    return ssnChgCd;
  }

  public void setSsnChgCd(String ssnChgCd) {
    this.ssnChgCd = ssnChgCd;
  }

  public String getSufxTldsc() {
    return sufxTldsc;
  }

  public void setSufxTldsc(String sufxTldsc) {
    this.sufxTldsc = sufxTldsc;
  }

  public String getUnemplyCd() {
    return unemplyCd;
  }

  public void setUnemplyCd(String unemplyCd) {
    this.unemplyCd = unemplyCd;
  }

  public String getLstUpdId() {
    return lstUpdId;
  }

  public void setLstUpdId(String lstUpdId) {
    this.lstUpdId = lstUpdId;
  }

  public Timestamp getLstUpdTs() {
    return lstUpdTs;
  }

  public void setLstUpdTs(Timestamp lstUpdTs) {
    this.lstUpdTs = lstUpdTs;
  }

  public String getCommntDsc() {
    return commntDsc;
  }

  public void setCommntDsc(String commntDsc) {
    this.commntDsc = commntDsc;
  }

  public String getEstDobCd() {
    return estDobCd;
  }

  public void setEstDobCd(String estDobCd) {
    this.estDobCd = estDobCd;
  }

  public String getBpVerInd() {
    return bpVerInd;
  }

  public void setBpVerInd(String bpVerInd) {
    this.bpVerInd = bpVerInd;
  }

  public String getHispCd() {
    return hispCd;
  }

  public void setHispCd(String hispCd) {
    this.hispCd = hispCd;
  }

  public String getCurrcaInd() {
    return currcaInd;
  }

  public void setCurrcaInd(String currcaInd) {
    this.currcaInd = currcaInd;
  }

  public String getCurregInd() {
    return curregInd;
  }

  public void setCurregInd(String curregInd) {
    this.curregInd = curregInd;
  }

  public String getCothDesc() {
    return cothDesc;
  }

  public void setCothDesc(String cothDesc) {
    this.cothDesc = cothDesc;
  }

  public String getPrevcaInd() {
    return prevcaInd;
  }

  public void setPrevcaInd(String prevcaInd) {
    this.prevcaInd = prevcaInd;
  }

  public String getPreregInd() {
    return preregInd;
  }

  public void setPreregInd(String preregInd) {
    this.preregInd = preregInd;
  }

  public String getPothDesc() {
    return pothDesc;
  }

  public void setPothDesc(String pothDesc) {
    this.pothDesc = pothDesc;
  }

  public String getHcareInd() {
    return hcareInd;
  }

  public void setHcareInd(String hcareInd) {
    this.hcareInd = hcareInd;
  }

  public String getLimitInd() {
    return limitInd;
  }

  public void setLimitInd(String limitInd) {
    this.limitInd = limitInd;
  }

  public String getBirthCity() {
    return birthCity;
  }

  public void setBirthCity(String birthCity) {
    this.birthCity = birthCity;
  }

  public String getHealthTxt() {
    return healthTxt;
  }

  public void setHealthTxt(String healthTxt) {
    this.healthTxt = healthTxt;
  }

  public LocalDate getMtermDt() {
    return mtermDt;
  }

  public void setMtermDt(LocalDate mtermDt) {
    this.mtermDt = mtermDt;
  }

  public LocalDate getFtermDt() {
    return ftermDt;
  }

  public void setFtermDt(LocalDate ftermDt) {
    this.ftermDt = ftermDt;
  }

  public String getZippyInd() {
    return zippyInd;
  }

  public void setZippyInd(String zippyInd) {
    this.zippyInd = zippyInd;
  }

  public String getDeathPlc() {
    return deathPlc;
  }

  public void setDeathPlc(String deathPlc) {
    this.deathPlc = deathPlc;
  }

  public String getTrMbvrtB() {
    return trMbvrtB;
  }

  public void setTrMbvrtB(String trMbvrtB) {
    this.trMbvrtB = trMbvrtB;
  }

  public String getTrbaCltB() {
    return trbaCltB;
  }

  public void setTrbaCltB(String trbaCltB) {
    this.trbaCltB = trbaCltB;
  }

  public String getSoc158Ind() {
    return soc158Ind;
  }

  public void setSoc158Ind(String soc158Ind) {
    this.soc158Ind = soc158Ind;
  }

  public String getDthDtInd() {
    return dthDtInd;
  }

  public void setDthDtInd(String dthDtInd) {
    this.dthDtInd = dthDtInd;
  }

  public String getEmailAddr() {
    return emailAddr;
  }

  public void setEmailAddr(String emailAddr) {
    this.emailAddr = emailAddr;
  }

  public String getAdjdelInd() {
    return adjdelInd;
  }

  public void setAdjdelInd(String adjdelInd) {
    this.adjdelInd = adjdelInd;
  }

  public String getEthUdCd() {
    return ethUdCd;
  }

  public void setEthUdCd(String ethUdCd) {
    this.ethUdCd = ethUdCd;
  }

  public String getHispUdCd() {
    return hispUdCd;
  }

  public void setHispUdCd(String hispUdCd) {
    this.hispUdCd = hispUdCd;
  }

  public String getSocplcCd() {
    return socplcCd;
  }

  public void setSocplcCd(String socplcCd) {
    this.socplcCd = socplcCd;
  }

  public String getClIndxNo() {
    return clIndxNo;
  }

  public void setClIndxNo(String clIndxNo) {
    this.clIndxNo = clIndxNo;
  }
}
