package com.example.dataBaseAGDRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.dataBaseAGDRestApi.appliance")
public class DataBaseAgdRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseAgdRestApiApplication.class, args);
	}

}
