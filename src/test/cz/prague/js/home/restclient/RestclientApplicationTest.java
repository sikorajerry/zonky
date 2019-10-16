package cz.prague.js.home.restclient;

import cz.prague.js.home.restclient.model.Marketplace;
import org.junit.Test;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestclientApplicationTest {

    @Test
    public void callMarketplaceRestApiTest() {

        final Map<String, Object> templateValues = new HashMap<>();
        templateValues.put("datePublished__gt" ,"2019-10-14T15:05:55.447+02:00");


        Invocation.Builder marketplaceInvocationBuilder = ConfigUtils.getInvocationBuilder("marketplace", templateValues);

        List<Marketplace> marketplaces = marketplaceInvocationBuilder.get(new GenericType<List<Marketplace>>()  {});

        System.out.println(marketplaces.size());
    }

}
