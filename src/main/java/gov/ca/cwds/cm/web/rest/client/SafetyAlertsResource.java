package gov.ca.cwds.cm.web.rest.client;

import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import gov.ca.cwds.cm.Constants;
import gov.ca.cwds.cm.service.SafetyAlertService;
import gov.ca.cwds.cm.service.dictionaries.ClientType;
import gov.ca.cwds.cm.service.dto.ClientAddressDTO;
import gov.ca.cwds.cm.service.dto.ClientDTO;
import gov.ca.cwds.cm.service.dto.SafetyAlertDTO;
import gov.ca.cwds.cm.service.facade.ClientFacade;
import gov.ca.cwds.cm.web.rest.ResponseUtil;
import gov.ca.cwds.cm.web.rest.parameter.ClientParameterObject;
import io.dropwizard.hibernate.UnitOfWork;
import io.swagger.annotations.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.Collection;

import static gov.ca.cwds.cm.Constants.API.CLIENTS;
import static gov.ca.cwds.cm.Constants.API.ID;
import static gov.ca.cwds.cm.Constants.UnitOfWork.CMS;

/** @author CWDS TPT-3 Team */
@Api(tags = CLIENTS, value = CLIENTS)
@Path(value = CLIENTS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SafetyAlertsResource {

  private SafetyAlertService safetyAlertService;

  @Inject
  public SafetyAlertsResource(SafetyAlertService safetyAlertService) {
    this.safetyAlertService = safetyAlertService;
  }

  @GET
  @Path("/{" + ID + "}/" + Constants.API.SAFETY_ALERTS)
  @ApiResponses(
    value = {
      @ApiResponse(code = 401, message = "Not Authenticated"),
      @ApiResponse(code = 403, message = "Unauthorized"),
      @ApiResponse(code = 404, message = "Not found")
    }
  )
  @ApiOperation(value = "Find safety alerts by client ID", response = SafetyAlertDTO.class)
  @UnitOfWork(CMS)
  @Timed
  public Response get(
      @PathParam("id")
          @ApiParam(required = true, value = "The unique client ID", example = "0YIPkZU0S0")
          final String id) {
    final Collection<SafetyAlertDTO> safetyAlerts =
        safetyAlertService.findSafetyAlertsByClientId(id);
    return ResponseUtil.responseOrNotFound(safetyAlerts);
  }
}
