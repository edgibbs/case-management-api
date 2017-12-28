package gov.ca.cwds.cm;

import com.google.inject.Module;
import gov.ca.cwds.authorizer.ClientAbstractReadAuthorizer;
import gov.ca.cwds.cm.inject.ApplicationModule;
import gov.ca.cwds.cm.inject.DataAccessModule;
import gov.ca.cwds.rest.BaseApiApplication;
import gov.ca.cwds.security.module.SecurityModule;
import io.dropwizard.setup.Bootstrap;

/**
 * @author CWDS TPT-3 Team
 */

public class CmApiApplication extends BaseCmApiApplication<CmApiConfiguration> {

  public static void main(String[] args) throws Exception {
    new CmApiApplication().run(args);
  }

  @Override
  public Module applicationModule(final Bootstrap<CmApiConfiguration> bootstrap) {
    return new ApplicationModule<CmApiConfiguration>(bootstrap) {
      @Override
      protected void configure() {
        super.configure();
        install(new DataAccessModule(bootstrap));
        install(new SecurityModule(BaseApiApplication::getInjector)
            .addAuthorizer("client:read", ClientAbstractReadAuthorizer.class)
        );
      }
    };
  }

}
