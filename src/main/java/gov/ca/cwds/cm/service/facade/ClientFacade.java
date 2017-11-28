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

    private ChildClientService childClientService;

    @Inject
    public ClientFacade(ChildClientService childClientService) {
        this.childClientService = childClientService;
    }

    public Response find(Serializable serializable, ClientType clientType) {
        if (ClientType.CHILD_CLIENT.equals(clientType)) {
            return childClientService.find(serializable);
        }
        return null;
    }

}
