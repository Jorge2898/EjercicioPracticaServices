package com.example.ejercicio.factura.facturamongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FacturamongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturamongoApplication.class, args);
	}

}
