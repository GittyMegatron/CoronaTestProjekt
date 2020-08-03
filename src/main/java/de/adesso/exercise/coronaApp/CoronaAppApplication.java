package de.adesso.exercise.coronaApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableMongoRepositories
@SpringBootApplication
public class CoronaAppApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(CoronaAppApplication.class, args);
		
	}

}
