package com.example.Trotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.Trotter.CustomerBookingRequest")
public class TrotterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrotterApplication.class, args);
	}

}
