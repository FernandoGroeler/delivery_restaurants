package delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DeliveryRestaurantsApplication {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "restaurants-delivery");
		SpringApplication.run(DeliveryRestaurantsApplication.class, args);
	}
}
