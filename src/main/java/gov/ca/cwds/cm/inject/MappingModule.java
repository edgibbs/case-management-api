package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cm.service.mapper.CaseMapper;

/**
 * DI (dependency injection) setup for mapping classes.
 *
 * @author CWDS TPT-3 Team
 */
public class MappingModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CaseMapper.class).to(CaseMapper.INSTANCE.getClass()).asEagerSingleton();
  }
}
