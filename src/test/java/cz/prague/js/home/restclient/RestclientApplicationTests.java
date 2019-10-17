package cz.prague.js.home.restclient;

import cz.prague.js.home.restclient.model.Marketplace;
import cz.prague.js.home.restclient.service.MarketplaceService;
import cz.prague.js.home.restclient.task.PrintTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RestclientApplicationTests {

	@Mock
	private MarketplaceService marketplaceService;

	@InjectMocks
	private PrintTask printTask;

	@Test
	public void commonSampleTaskTest() {

		List<Marketplace> marketplaces = preparedDataForTest();

		Mockito.when(marketplaceService.getMarketplaceDataInLastFiveMinutes()).thenReturn(marketplaces);

		List<Marketplace> marketplacesFromUpdate = printTask.updateNewDataFromMarketplace();

		marketplaces.remove(1);

		Assert.assertEquals(marketplaces.get(0), marketplacesFromUpdate.get(0));
		Assert.assertEquals(marketplaces.get(1), marketplacesFromUpdate.get(1));
	}

	private List<Marketplace> preparedDataForTest() {
		LocalDateTime localDateTime1 = LocalDateTime.now().minusMinutes(5l);
		Date date1 = Date.from( localDateTime1.atZone( ZoneId.systemDefault()).toInstant());

		LocalDateTime localDateTime2 = LocalDateTime.now().minusMinutes(4l);
		Date date2 = Date.from( localDateTime2.atZone( ZoneId.systemDefault()).toInstant());

		LocalDateTime localDateTime3 = LocalDateTime.now().minusMinutes(6l);
		Date date3 = Date.from( localDateTime3.atZone( ZoneId.systemDefault()).toInstant());

		Marketplace marketplace1 = new Marketplace();
		marketplace1.setId(1);
		marketplace1.setUrl("www.sample1.com");
		marketplace1.setDatePublished(date1);

		Marketplace marketplace2 = new Marketplace();
		marketplace2.setId(2);
		marketplace2.setUrl("www.sample2.com");
		marketplace2.setDatePublished(date2);

		Marketplace marketplace3 = new Marketplace();
		marketplace3.setId(3);
		marketplace3.setUrl("www.sample3.com");
		marketplace3.setDatePublished(date3);

		return new ArrayList<Marketplace>() {{
			add(marketplace1);
			add(marketplace2);
			add(marketplace3);
		}};




	}
}
