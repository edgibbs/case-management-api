package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.Constants.API;
import io.swagger.annotations.Api;
import java.time.LocalDate;

import static gov.ca.cwds.cm.Constants.API.CHILD_CLIENTS;
import static gov.ca.cwds.cm.Constants.API.ID;
import static gov.ca.cwds.cm.Constants.UnitOfWork.CMS;

import com.codahale.metrics.annotation.Timed;
import gov.ca.cwds.cm.service.dto.CSECHistoryDTO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** @author CWDS TPT-3 Team */
@Api(tags = CHILD_CLIENTS, value = CHILD_CLIENTS)
@Path(value = CHILD_CLIENTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CSECHistoryResource {

  @GET
  @Path("/{" + ID + "}/" + API.CSEC_HISTORY)
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @UnitOfWork(CMS)
  @Timed
  @ApiOperation(
    value = "Find CSEC information pertaining to a specific child client",
    response = CSECHistoryDTO.class
  )
  public Response getCSECByClientId(
      @PathParam(ID)
          @ApiParam(required = true, value = "Child Client ID", example = "BKk7CHj01Y")
          final String clientId) {

    if (!"BKk7CHj01Y".equals(clientId)) {
      return Response.ok().status(Response.Status.NOT_FOUND).build();
    }

    return Response.ok().entity(getMockedData()).build();
  }

  private List<CSECHistoryDTO> getMockedData() {
    String clientId = "BKk7CHj01Y";

    CSECHistoryDTO dto = new CSECHistoryDTO();
    dto.setStartDate(LocalDate.of(1988, 10, 12));
    dto.setEndDate(LocalDate.of(1989, 10, 12));
    dto.setChildClientId(clientId);
    dto.setSexualExploitationType("6867");

    CSECHistoryDTO dto2 = new CSECHistoryDTO();
    dto2.setStartDate(LocalDate.of(1998, 10, 12));
    dto2.setEndDate(LocalDate.of(1999, 10, 12));
    dto2.setChildClientId(clientId);
    dto2.setSexualExploitationType("6867");

    return Arrays.asList(dto, dto2);
  }
}
