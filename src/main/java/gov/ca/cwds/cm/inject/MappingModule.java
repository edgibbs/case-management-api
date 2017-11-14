package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;

/**
 * DI (dependency injection) setup for mapping classes.
 *
 * @author CWDS TPT-3 Team
 */

public class MappingModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ChildClientMapper.class).to(ChildClientMapper.INSTANCE.getClass())
            .asEagerSingleton();
  }

}


