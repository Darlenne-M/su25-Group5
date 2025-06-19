package com.example.Trotter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.example.Trotter.CustomerProfile",
										"com.example.Trotter.ProviderServices",
										"com.example.Trotter.CustomerWriteReview",
										"com.example.Trotter.ProviderBookings",
										"com.example.Trotter.ProviderProfile"})  //(basePackages = "com.example.Trotter.CustomerBookingRequest") //*edit-ser 
public class TrotterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrotterApplication.class, args);
	}

}
