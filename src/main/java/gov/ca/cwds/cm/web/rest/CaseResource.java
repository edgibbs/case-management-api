package gov.ca.cwds.cm.web.rest;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.CaseService;
import gov.ca.cwds.cm.service.dto.CaseDTO;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.Constants.API.CASE;

/** @author CWDS TPT-3 Team */
@Api(tags = CASE, value = CASE)
@Path(value = CASE)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CaseResource {

  private CaseService caseService;

  @Inject
  public CaseResource(CaseService caseService) {
    this.caseService = caseService;
  }

  @GET
  @Path("/{id}")
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @UnitOfWork
  @ApiOperation(value = "Find Case by case ID", response = CaseDTO.class, code = 200)
  public Response get(
      @PathParam("id")
          @ApiParam(required = true, value = "The unique case ID", example = "AadfKnG07n")
          String id) {
    CaseDTO caseDTO = caseService.find(id);
    if (caseDTO != null) {
      return Response.status(Response.Status.OK).entity(caseDTO).build();
    }
    return Response.status(Response.Status.NOT_FOUND).build();
  }
}
