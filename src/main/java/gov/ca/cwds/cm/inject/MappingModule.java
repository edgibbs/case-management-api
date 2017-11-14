package gov.ca.cwds.cm.inject;

import com.google.inject.AbstractModule;
import gov.ca.cwds.cm.service.mapper.AddressMapper;
import gov.ca.cwds.cm.service.mapper.ChildClientMapper;
import gov.ca.cwds.cm.service.mapper.CaseMapper;
import org.mapstruct.factory.Mappers;

/**
 * DI (dependency injection) setup for mapping classes.
 *
 * @author CWDS TPT-3 Team
 */
public class MappingModule extends AbstractModule {

  private static Class getMapperImpl(Class mapperClass) {
    return Mappers.getMapper(mapperClass).getClass();
  }

  @Override
  protected void configure() {
    bind(CaseMapper.class).to(CaseMapper.INSTANCE.getClass()).asEagerSingleton();
    bind(AddressMapper.class).to(getMapperImpl(AddressMapper.class)).asEagerSingleton();
    bind(ChildClientMapper.class).to(ChildClientMapper.INSTANCE.getClass())
            .asEagerSingleton();
  }
}
