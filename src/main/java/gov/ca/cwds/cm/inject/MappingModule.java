package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;
import gov.ca.cwds.cm.service.mapper.CaseMapper;
import gov.ca.cwds.cm.service.mapper.ClientMapper;

/**
 * DI (dependency injection) setup for mapping classes.
 *
 * @author CWDS TPT-3 Team
 */
public class MappingModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(CaseMapper.class).to(CaseMapper.INSTANCE.getClass()).asEagerSingleton();
    bind(ClientMapper.class).to(ClientMapper.INSTANCE.getClass()).asEagerSingleton();
    bind(ChildClientMapper.class).to(ChildClientMapper.INSTANCE.getClass()).asEagerSingleton();
  }
}
