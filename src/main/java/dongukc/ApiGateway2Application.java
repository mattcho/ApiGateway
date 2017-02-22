package dongukc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiGateway2Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateway2Application.class, args);
	}
}
