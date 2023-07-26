package com.fabianpalma.relaciones1n;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication

@EntityScan("com.fabianpalma.relaciones1.models")
public class Relaciones1aNApplication {

	public static void main(String[] args) {
		SpringApplication.run(Relaciones1aNApplication.class, args);
	}

}
