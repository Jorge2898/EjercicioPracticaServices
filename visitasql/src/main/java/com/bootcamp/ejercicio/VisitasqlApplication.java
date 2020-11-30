package com.bootcamp.ejercicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VisitasqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(VisitasqlApplication.class, args);
	}

}
