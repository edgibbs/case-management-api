package gov.ca.cwds.cm.service;

import gov.ca.cwds.cm.service.dto.search.result.SearchResultDTO;
import gov.ca.cwds.cm.service.dto.search.criteria.BaseCriteriaDTO;

/**
 * @author CWDS TPT-3 Team
 */
public abstract class SearchableCrudServiceAdapter extends CrudServiceAdapter implements SearchableService {

  @Override
  public SearchResultDTO search(BaseCriteriaDTO criteria) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Long searchTotalCount(BaseCriteriaDTO criteria) {
    throw new UnsupportedOperationException();
  }
}
