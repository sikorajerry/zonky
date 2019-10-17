package cz.prague.js.home.restclient.factory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * Created by Jiri Sikora
 * WebClientFactory prepared for us inicialization invocationBuilder for call by rest api command
 */
public class WebClientFactory {

    private static final String ZONKY_ROOT_URL = "https://api.zonky.cz/loans/";
    private static final String MARKETPLACE_ENDPOINT_PATH = "marketplace";

    private WebClientFactory() {
    }

    /**
     * static Method which set specific endpoint for invocationBuilder
     * @param date
     * @return invocationBuilder
     */
    public static Invocation.Builder getInvocationBuilder(final String date) {

        Client client = ClientBuilder.newClient();

        WebTarget webTarget = client.target(ZONKY_ROOT_URL);

        WebTarget employeeWebTarget = webTarget.path(MARKETPLACE_ENDPOINT_PATH).queryParam("datePublished__gt", date);


        return employeeWebTarget.request(MediaType.APPLICATION_JSON_TYPE);
    }
}
