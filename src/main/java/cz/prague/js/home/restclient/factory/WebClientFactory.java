package cz.prague.js.home.restclient.factory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class WebClientFactory {

    private static final String ZONKY_ROOT_URL = "https://api.zonky.cz/loans/";
    private static final String MARKETPLACE_ENDPOINT_PATH = "marketplace";

    public static Invocation.Builder getInvocationBuilder() {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(ZONKY_ROOT_URL);

        WebTarget employeeWebTarget = webTarget.path(MARKETPLACE_ENDPOINT_PATH);

        Invocation.Builder invocationBuilder = employeeWebTarget.request(MediaType.APPLICATION_JSON_TYPE);

        return invocationBuilder;
    }
}
