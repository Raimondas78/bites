package com.raimondas.bites;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bites Application API", version = "1.0",
		description = "Customer and Service information"))
public class BitesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitesApplication.class, args);
	}

}
