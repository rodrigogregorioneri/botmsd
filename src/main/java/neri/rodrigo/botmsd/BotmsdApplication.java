package neri.rodrigo.botmsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class BotmsdApplication {

	public static void main(String[] args) {
		SpringApplication.run(BotmsdApplication.class, args);
	}

}
