package gov.ca.cwds.cm.web.rest;

import com.google.inject.Inject;
import gov.ca.cwds.cm.inject.ChildClientServiceBackedResource;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.web.rest.parameter.ChildClientParameterObject;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.Constants.API.CHILD_CLIENT;

/** @author CWDS TPT-3 Team */
@Api(tags = CHILD_CLIENT, value = CHILD_CLIENT)
@Path(value = CHILD_CLIENT)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildClientResource {

  private ResourceDelegate childClientResourceDelegat;

  @Inject
  public ChildClientResource(
      @ChildClientServiceBackedResource ResourceDelegate childClientResourceDelegat) {
    this.childClientResourceDelegat = childClientResourceDelegat;
  }

  @GET
  @Path("/{clientId}")
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @ApiOperation(
    value = "Find childClient by client ID",
    response = ChildClientDTO.class,
    code = 200
  )
  @UnitOfWork
  public Response get(
      @PathParam("clientId")
          @ApiParam(required = true, value = "The unique client ID", example = "DSC1233117")
          String clientId) {
    ChildClientParameterObject childClientParameterObject = new ChildClientParameterObject();
    childClientParameterObject.setChildClientId(clientId);
    Response childClientDTO = childClientResourceDelegat.get(childClientParameterObject);
    System.out.println(childClientDTO.getEntity());
    return Response.ok().entity(childClientDTO.getEntity()).build();
  }
}
