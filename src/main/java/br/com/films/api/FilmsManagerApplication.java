package br.com.films.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FilmsManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmsManagerApplication.class, args);
	}

}
