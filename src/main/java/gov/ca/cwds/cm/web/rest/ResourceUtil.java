package gov.ca.cwds.cm.web.rest;

import gov.ca.cwds.cm.service.dto.CollectionDTO;
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
   * @param dto - payload of the response
   * @return
   */
  public static Response responseOrNotFound(final Object dto) {
    return Response
        .status(dto == null ? 404 : 200)
        .entity(dto)
        .build();
  }

  /**
   * Returns JAX-RS Response with body and 200 (OK) HTTP code or simply 404 (Not Found) HTTP code
   * @param collectionDTO - payload as collection of items
   * @return
   */
  public static Response responseOrNotFound(final CollectionDTO collectionDTO) {
    final boolean isCollectionDtoEmpty = isCollectionDtoEmpty(collectionDTO);
    return Response
        .status(isCollectionDtoEmpty ? 404 : 200)
        .entity(isCollectionDtoEmpty ? null : collectionDTO)
        .build();
  }

  private static boolean isCollectionDtoEmpty(final CollectionDTO<?> collectionDTO) {
    return collectionDTO == null
        || collectionDTO.getItems() == null
        || collectionDTO.getItems().isEmpty();
  }
}
