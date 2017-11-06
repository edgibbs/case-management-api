package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Identifies all CM_UNIT_OF_WORK API business layer (services) classes available for dependency
 * injection by Guice.
 *
 * @author CWDS TPT-3 Team
 */
public class ServicesModule extends AbstractModule {

  private static final Logger LOG = LoggerFactory.getLogger(ServicesModule.class);

  /**
   * Default constructor
   */
  public ServicesModule() {
    // Do nothing - Default constructor
  }

  /**
   * Do Nothing
   */
  @Override
  protected void configure() {
    LOG.debug("ServicesModule configure method");
  }

}
