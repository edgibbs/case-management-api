package gov.ca.cwds.cm.service.facade;

import com.google.inject.Inject;
import gov.ca.cwds.cm.service.ChildClientService;
import gov.ca.cwds.cm.service.dictionaries.ClientType;
import gov.ca.cwds.rest.api.Response;

import java.io.Serializable;

/**
 * @author CWDS TPT-3 Team
 */
public class ClientFacade {

    @Inject
    private ChildClientService childClientService;

    public Response find(Serializable serializable, ClientType clientType) {
        switch (clientType) {
            case CHILD_CLIENT:
                return childClientService.find(serializable);
            default:
                return null;
        }
    }

}
