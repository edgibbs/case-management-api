package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static gov.ca.cwds.cm.Constants.API.CHILD_CLIENT;

/**
 * @author CWDS TPT-3 Team
 */
@Api(tags = CHILD_CLIENT, value = CHILD_CLIENT)
@Path(value = CHILD_CLIENT)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildClientResource {

    @GET
    @Path("/{clientId}")
    @ApiResponses(value = {@ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 404, message = "Not found"),
            @ApiResponse(code = 406, message = "Accept Header not supported")})
    @ApiOperation(value = "Find childClient by client ID", response = ChildClientDTO.class, code = 200)
    public Response get(@PathParam("clientId") @ApiParam(required = true, value = "The unique client ID",
            example = "DSC1233117") String clientId) {
        return Response.ok().entity(new ChildClientDTO()).build();
    }

}
