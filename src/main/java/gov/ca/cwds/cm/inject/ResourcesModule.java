package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cm.web.rest.system.SystemInformationResource;

/**
 * Identifies all CM_UNIT_OF_WORK API domain resource classes available for dependency injection
 * by Guice.
 *
 * @author CWDS TPT-3 Team
 */
public class ResourcesModule extends AbstractModule {

  /**
   * Default constructor
   */
  public ResourcesModule() {
    // Do nothing - Default Constructor
  }

  @Override
  protected void configure() {
    bind(SystemInformationResource.class);
  }

}
