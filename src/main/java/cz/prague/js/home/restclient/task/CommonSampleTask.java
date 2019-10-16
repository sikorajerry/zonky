package cz.prague.js.home.restclient.task;

import cz.prague.js.home.restclient.model.Marketplace;
import cz.prague.js.home.restclient.service.MarketplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommonSampleTask {

    private MarketplaceService marketplaceService;

    @Autowired
    public CommonSampleTask(MarketplaceService marketplaceService) {
         this.marketplaceService=marketplaceService;
    }

    public List<Marketplace> updateNewDataFromMarketplace() {

        List<Marketplace> allMarketplaceData = marketplaceService.getAllMarketplaceData();

        LocalDateTime localDateTime = LocalDateTime.now().minusMinutes(5l);
        Date date = Date.from( localDateTime.atZone( ZoneId.systemDefault()).toInstant());

        List<Marketplace> marketplacesInLastFiveMinutes = allMarketplaceData.stream().filter(marketplace -> (marketplace.getDatePublished().compareTo(date)<0)).collect(Collectors.toList());

        return marketplacesInLastFiveMinutes;
    }

    public void printMarketplaces(List<Marketplace> marketplaces) {
        for (Marketplace marketplace: marketplaces) {
            System.out.println(marketplace);
        }
    }

    public void printAllLastFiveMinutesRecords() {
      printMarketplaces(updateNewDataFromMarketplace());
    }
}
