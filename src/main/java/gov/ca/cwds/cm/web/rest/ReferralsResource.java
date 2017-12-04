package gov.ca.cwds.cm.web.rest;

import static gov.ca.cwds.cm.Constants.API.REFERRAL;

import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import gov.ca.cwds.ObjectMapperUtils;
import gov.ca.cwds.cm.service.dto.ReferralDTO;
import gov.ca.cwds.cm.service.dto.search.criteria.ReferralSearchCriteria;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.testing.FixtureHelpers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** @author CWDS TPT-3 Team */
@Api(tags = REFERRAL, value = REFERRAL)
@Path(value = REFERRAL)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReferralsResource {

  @POST
  @Path("/_search")
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @ApiOperation(value = "Search referrals by criteria", response = ReferralDTO[].class)
  @UnitOfWork
  @Timed
  public Response search(@ApiParam ReferralSearchCriteria referralSearchCriteria)
      throws IOException {
    if (!"-1".equals(referralSearchCriteria.getStaffId())) {
      return Response.status(200).entity(new ArrayList<>()).build();
    }

    return ResponseUtil.responseOrNotFound(getMockedData());
  }

  private List<ReferralDTO> getMockedData() throws IOException {
    ObjectMapper objectMapper = ObjectMapperUtils.createObjectMapper();
    objectMapper.registerModule(new Jdk8Module()).registerModule(new JavaTimeModule());
    String json = FixtureHelpers.fixture("fixtures/referrals_by_staff_id_mock.json");
    ReferralDTO[] array = objectMapper.readValue(json, ReferralDTO[].class);
    return Arrays.asList(array);
  }
}
