package gov.ca.cwds.cm.service;

import org.junit.Test;

/**
 * @author CWDS TPT-3 Team
 */
public class SearchableCrudServiceAdapterTest {

  private final SearchableCrudServiceAdapter testSubject = new SearchableCrudServiceAdapter() {};

  @Test(expected = UnsupportedOperationException.class)
  public void search() {
    testSubject.search(null);
  }

  @Test(expected = UnsupportedOperationException.class)
  public void searchTotalCount() {
    testSubject.searchTotalCount(null);
  }

}