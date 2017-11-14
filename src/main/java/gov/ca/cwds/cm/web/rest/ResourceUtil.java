package gov.ca.cwds.cm.web.rest;

import javax.ws.rs.core.Response;

/**
 * Common Resource methods
 *
 * @author CWDS TPT-3 Team
 */
public final class ResourceUtil {

  private ResourceUtil() {
  }

  /**
   * Returns JAX-RS Response with body and 200 (OK) HTTP code or simply 404 (Not Found) HTTP code
   * @param dto
   * @return
   */
  public static Response responseOrNotFound(final Object dto) {
    return Response
        .status(dto == null ? 404 : 200)
        .entity(dto)
        .build();
  }
}
