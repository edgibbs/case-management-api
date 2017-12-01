package gov.ca.cwds.cm.service;

import gov.ca.cwds.cm.service.dto.search.result.SearchResultDTO;
import gov.ca.cwds.cm.service.dto.search.criteria.BaseCriteriaDTO;

/**
 * @author CWDS TPT-3 Team
 */

interface SearchableService<T extends BaseCriteriaDTO> {

  SearchResultDTO search(T criteria);

  Long searchTotalCount(T criteria);

}
