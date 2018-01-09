package gov.ca.cwds.cm;

import com.fasterxml.jackson.annotation.JsonProperty;
import gov.ca.cwds.rest.BaseApiConfiguration;
import io.dropwizard.db.DataSourceFactory;

public class CmApiConfiguration extends BaseApiConfiguration {

  private DataSourceFactory cwsRsDataSourceFactory;

  @JsonProperty
  public DataSourceFactory getCwsRsDataSourceFactory() {
    return cwsRsDataSourceFactory;
  }

  public void setCwsRsDataSourceFactory(DataSourceFactory cwsRsDataSourceFactory) {
    this.cwsRsDataSourceFactory = cwsRsDataSourceFactory;
  }
}
