package gov.ca.cwds.cm.web.rest;

import com.codahale.metrics.annotation.Timed;
import static gov.ca.cwds.cm.Constants.API.CHILD_CLIENT;

import com.google.inject.Inject;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.inject.ChildClientServiceBackedResource;
import gov.ca.cwds.cm.service.ClientAddressService;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.service.dto.ClientAddressDTO;
import gov.ca.cwds.cm.service.dto.CollectionDTO;
import gov.ca.cwds.cm.web.rest.parameter.ChildClientParameterObject;
import gov.ca.cwds.rest.resources.ResourceDelegate;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/** @author CWDS TPT-3 Team */
@Api(tags = CHILD_CLIENT, value = CHILD_CLIENT)
@Path(value = CHILD_CLIENT)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildClientResource {

  private final ResourceDelegate childClientResourceDelegate;
  private final ClientAddressService clientAddressService;

  @Inject
  public ChildClientResource(
      @ChildClientServiceBackedResource ResourceDelegate childClientResourceDelegate,
      ClientAddressService clientAddressService) {
    this.childClientResourceDelegate = childClientResourceDelegate;
    this.clientAddressService = clientAddressService;
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
  @ApiOperation(
    value = "Find childClient by client ID",
    response = ChildClientDTO.class
  )
  @UnitOfWork
  @Timed
  public Response get(
      @PathParam("id")
      @ApiParam(required = true, value = "The unique client ID", example = "DSC1233117")
      final String id) {
    ChildClientParameterObject childClientParameterObject = new ChildClientParameterObject();
    childClientParameterObject.setChildClientId(id);
    Response childClientDTO = childClientResourceDelegate.get(childClientParameterObject);
    return Response.ok().entity(childClientDTO.getEntity()).build();
  }

  @GET
  @Path("/{id}/" + API.ADDRESSES)
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found")
    }
  )
  @ApiOperation(
    value = "ClientAddresses of ChildClient by client Id",
    response = ClientAddressDTO.class
  )
  @UnitOfWork
  public Response getAddressesByClientId(
      @PathParam("id")
      @ApiParam(required = true, value = "The unique client ID", example = "GmNMeSx0Hy")
      final String id) {
    final CollectionDTO<ClientAddressDTO> addresses = clientAddressService.findByClientId(id);
    return ResourceUtil.responseOrNotFound(addresses);
  }
}
