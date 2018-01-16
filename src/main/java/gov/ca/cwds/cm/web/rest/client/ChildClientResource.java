package gov.ca.cwds.cm.web.rest.client;

import static gov.ca.cwds.cm.Constants.API.CHILD_CLIENTS;
import static gov.ca.cwds.cm.Constants.API.ID;
import static gov.ca.cwds.cm.Constants.UnitOfWork.CMS;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cm.Constants.API;
import gov.ca.cwds.cm.service.ChildClientService;
import gov.ca.cwds.cm.service.ClientAddressService;
import gov.ca.cwds.cm.service.dictionaries.ClientType;
import gov.ca.cwds.cm.service.dto.ChildClientDTO;
import gov.ca.cwds.cm.service.dto.ClientAddressDTO;
import gov.ca.cwds.cm.service.dto.ClientRelationshipDTO;
import gov.ca.cwds.cm.service.facade.ClientFacade;
import gov.ca.cwds.cm.web.rest.ResponseUtil;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import gov.ca.cwds.cms.data.access.service.DataAccessServicesException;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
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
public class ChildClientResource {

  private final ClientFacade clientFacade;
  private final ClientAddressService clientAddressService;
  private ChildClientService childClientService;

  @Inject
  public ChildClientResource(
      ClientFacade clientFacade,
      ClientAddressService clientAddressService,
      ChildClientService childClientService) {
    this.clientAddressService = clientAddressService;
    this.clientFacade = clientFacade;
    this.childClientService = childClientService;
  }

  @GET
  @Path("/{" + ID + "}")
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 404, message = "Not found"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @ApiOperation(value = "Find childClient by client ID", response = ChildClientDTO.class)
  @UnitOfWork(CMS)
  @Timed
  public Response get(
      @PathParam("id")
          @ApiParam(required = true, value = "The unique client ID", example = "GmNMeSx0Hy")
          final String id) {
    final ClientParameterObject clientParameterObject = new ClientParameterObject();
    clientParameterObject.setClientId(id);
    final gov.ca.cwds.rest.api.Response clientDTO =
        clientFacade.find(clientParameterObject, ClientType.CHILD_CLIENT);
    return ResponseUtil.responseOrNotFound(clientDTO);
  }

  @GET
  @Path("/{" + ID + "}/" + API.ADDRESSES)
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authenticated"),
      @ApiResponse(code = 403, message = "Unauthorized"),
      @ApiResponse(code = 404, message = "Not found")
    }
  )
  @ApiOperation(
    value = "ClientAddresses of ChildClient by client Id",
    response = ClientAddressDTO.class
  )
  @UnitOfWork(CMS)
  @Timed
  public Response getAddressesByClientId(
      @PathParam("id")
          @ApiParam(required = true, value = "The unique client ID", example = "GmNMeSx0Hy")
          final String id) {
    final Collection<ClientAddressDTO> addresses = clientAddressService.findByClientId(id);
    return ResponseUtil.responseOrNotFound(addresses);
  }

  @GET
  @Path("/{" + ID + "}/" + API.RELATIONSHIPS)
  @ApiResponses(
      value = {
          @ApiResponse(code = 401, message = "Not Authenticated"),
          @ApiResponse(code = 403, message = "Unauthorized"),
          @ApiResponse(code = 404, message = "Not found")
      }
  )
  @ApiOperation(
      value = "ClientRelationships of ChildClient by client Id",
      response = ClientRelationshipDTO.class
  )
  public Response getRelationshipsByClientId(
      @PathParam("id")
      @ApiParam(required = true, value = "The unique client ID", example = "GmNMeSx0Hy")
      final String id) {
    final Collection<ClientRelationshipDTO> relationships = new ArrayList<>();

    ClientRelationshipDTO rel_0 = new ClientRelationshipDTO();
    rel_0.setRelationshipId("AcB3Wu00Rx");
    rel_0.setClientId("FplTfDs0Rx");
    rel_0.setRelatedClientId("MHH2zjk0Rx");
    rel_0.setRelationshipTypeCode((short)285);
    rel_0.setAbsentParentIndicator(true);
    rel_0.setRelationshipStartDate(LocalDate.of(2000, 10, 20));
    rel_0.setRelationshipEndDate(LocalDate.of(2018, 10, 20));
    rel_0.setSameHomeStatus("NO");
    relationships.add(rel_0);

    ClientRelationshipDTO rel_1 = new ClientRelationshipDTO();
    rel_1.setRelationshipId("AattSTp01T");
    rel_1.setClientId("FplTfDs0Rx");
    rel_1.setRelatedClientId("FEsDPrl01T");
    rel_1.setRelationshipTypeCode((short)291);
    rel_1.setAbsentParentIndicator(false);
    rel_1.setRelationshipStartDate(LocalDate.of(2000, 10, 20));
    rel_1.setRelationshipEndDate(LocalDate.of(2018, 10, 20));
    rel_1.setSameHomeStatus("YES");
    relationships.add(rel_1);

    return ResponseUtil.responseOrNotFound(relationships);
  }

  @PUT
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Timed
  @ApiResponses(
    value = {
      @ApiResponse(code = 400, message = "Bad request"),
      @ApiResponse(code = 404, message = "Not Found"),
      @ApiResponse(code = 401, message = "Not Authorized"),
      @ApiResponse(code = 406, message = "Accept Header not supported")
    }
  )
  @UnitOfWork(CMS)
  @ApiOperation(value = "Update client", response = ChildClientDTO.class)
  public Response update(
      @ApiParam(name = "client", value = "The Form object") @Valid ChildClientDTO childClient,
      @PathParam("id")
          @ApiParam(required = true, value = "The unique client ID", example = "GmNMeSx0Hy")
          final String id) throws DataAccessServicesException {
    return ResponseUtil.responseOrNotFound(childClientService.update(id, childClient));
  }
}
