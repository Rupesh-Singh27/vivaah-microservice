package com.vivaah.caterer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatererServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatererServiceApplication.class, args);
	}

}
