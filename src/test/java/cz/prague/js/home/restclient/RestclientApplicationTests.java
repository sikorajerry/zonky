package cz.prague.js.home.restclient;

import cz.prague.js.home.restclient.model.Marketplace;
import cz.prague.js.home.restclient.service.MarketplaceService;
import cz.prague.js.home.restclient.task.CommonSampleTask;
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
	private CommonSampleTask commonSampleTask;

//	@Test
//	public void contextLoadsTest() {
//		List<Marketplace> allMarketplaceData = service.getAllMarketplaceData();
//
//		System.out.println(allMarketplaceData);
//	}

	@Test
	public void commonSampleTaskTest() {

		Mockito.when(marketplaceService.getAllMarketplaceData()).thenReturn(preparedDataForTest());

		List<Marketplace> marketplaces = commonSampleTask.updateNewDataFromMarketplace();

		List<Marketplace> marketplaces1 = preparedDataForTest();
		marketplaces1.remove(1);

		Assert.assertEquals(marketplaces.size(), marketplaces1.size());
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
