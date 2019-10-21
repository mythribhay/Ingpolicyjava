package com.insurance.hcis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

/**
 * Description- This the main method for the springboot application.
 *
 */
@SpringBootApplication
@Slf4j
public class HealthinsuranceclaimsystemApplication {

	public static void main(String[] args) {
		log.info("Enter into main method");
		SpringApplication.run(HealthinsuranceclaimsystemApplication.class, args);
	}

}
