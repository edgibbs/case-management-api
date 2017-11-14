package gov.ca.cwds.cm.inject;

import com.google.common.collect.ImmutableList;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import gov.ca.cwds.cm.CmApiConfiguration;
import gov.ca.cwds.data.legacy.cms.entity.Case;
import gov.ca.cwds.data.legacy.cms.entity.ChildClient;
import gov.ca.cwds.data.legacy.cms.entity.StaffPerson;
import gov.ca.cwds.data.legacy.cms.entity.syscodes.*;
import gov.ca.cwds.inject.CmsHibernateBundle;
import gov.ca.cwds.inject.CmsSessionFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

import static gov.ca.cwds.cm.Constants.UnitOfWork.CMS;
import static gov.ca.cwds.cm.Constants.UnitOfWork.XA_CMS;

/** @author CWDS TPT-3 Team */
public class DataAccessModule extends AbstractModule {

  private final ImmutableList<Class<?>> cmsEntities =
      ImmutableList.<Class<?>>builder()
          .add(
              //      Client.class
              Case.class,
              Country.class,
              CaseClosureReasonType.class,
              ApprovalStatusType.class,
              ChildClient.class,
              StaffPerson.class,
              County.class,
              State.class,
              ActiveServiceComponentType.class)
          .build();

  private final HibernateBundle<CmApiConfiguration> cmsHibernateBundle =
      new HibernateBundle<CmApiConfiguration>(cmsEntities, new SessionFactoryFactory()) {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(CmApiConfiguration configuration) {
          return configuration.getCmsDataSourceFactory();
        }

        @Override
        public String name() {
          return CMS;
        }
      };

  public DataAccessModule(Bootstrap<? extends CmApiConfiguration> bootstrap) {
    bootstrap.addBundle(cmsHibernateBundle);
  }

  @Override
  protected void configure() {
    //do nothing
  }

  @Provides
  @CmsSessionFactory
  SessionFactory cmsSessionFactory() {
    return cmsHibernateBundle.getSessionFactory();
  }

  @Provides
  @CmsHibernateBundle
  public HibernateBundle<CmApiConfiguration> getCmsHibernateBundle() {
    return cmsHibernateBundle;
  }
}
