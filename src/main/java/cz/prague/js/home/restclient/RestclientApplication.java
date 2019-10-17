package cz.prague.js.home.restclient;

import cz.prague.js.home.restclient.task.PrintTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class RestclientApplication {

	@Autowired
	private PrintTask task;

	public static void main(String[] args) {
		SpringApplication.run(RestclientApplication.class, args);
	}

	@Scheduled(cron = "0 */5 * * * ?")
	public void cronJobSch() throws Exception {
		task.printAllLastFiveMinutesRecords();
	}

}
