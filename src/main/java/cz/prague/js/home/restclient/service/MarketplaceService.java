package cz.prague.js.home.restclient.service;

import cz.prague.js.home.restclient.factory.WebClientFactory;
import cz.prague.js.home.restclient.model.Marketplace;
import org.springframework.stereotype.Service;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by Jiri Sikora
 * Service for call specific remote endpoint and prepare records
 */
@Service
public class MarketplaceService {
    private static final long MINUTES = 5l;

    /**
     * Method with call endpoing with specific query , data are prepared when
     * are newest than MINUTES from now
     * @return List<Marketplace>
     */
    public List<Marketplace> getMarketplaceDataInLastFiveMinutes() {

        final LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(MINUTES);
        final DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        final String formatedDate = formatter.format(localDateTime);

        Invocation.Builder marketplaceInvocationBuilder = WebClientFactory.getInvocationBuilder(formatedDate);
        return marketplaceInvocationBuilder.get(new GenericType<List<Marketplace>>()  {});
    }

}
