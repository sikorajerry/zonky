package cz.prague.js.home.restclient.task;

import cz.prague.js.home.restclient.model.Marketplace;
import cz.prague.js.home.restclient.service.MarketplaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Component which printed data from remotely call
 */
@Component
public class CommonSampleTask {
    Logger logger = LoggerFactory.getLogger(CommonSampleTask.class);

    private MarketplaceService marketplaceService;

    @Autowired
    public CommonSampleTask(MarketplaceService marketplaceService) {
         this.marketplaceService=marketplaceService;
    }

    public List<Marketplace> updateNewDataFromMarketplace() {

        return marketplaceService.getMarketplaceDataInLastFiveMinutes();

    }

    public void printMarketplaces(List<Marketplace> marketplaces) {
        logger.info("IN LAST 5 MINUTES : " );
        if (!marketplaces.isEmpty()) {
            for (Marketplace marketplace: marketplaces) logger.info(marketplace.toString());
        } else {
            logger.info("NO RECORD FOUND ...");
        }
    }

    public void printAllLastFiveMinutesRecords() {
      printMarketplaces(updateNewDataFromMarketplace());
    }
}
