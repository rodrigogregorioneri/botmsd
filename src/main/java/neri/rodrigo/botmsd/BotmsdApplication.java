package neri.rodrigo.botmsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;


@SpringBootApplication
public class BotmsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotmsdApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {

		return builder.setConnectTimeout(Duration.ofMillis(3000)).setReadTimeout(Duration.ofMillis(3000)).build();
	}

}
