package cz.prague.js.home.restclient.service;

import cz.prague.js.home.restclient.factory.WebClientFactory;
import cz.prague.js.home.restclient.model.Marketplace;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import java.util.List;

@Service
public class MarketplaceService {

    public List<Marketplace> getAllMarketplaceData() {
        Invocation.Builder marketplaceInvocationBuilder = WebClientFactory.getInvocationBuilder();
        return marketplaceInvocationBuilder.get(new GenericType<List<Marketplace>>()  {});
    }

}
