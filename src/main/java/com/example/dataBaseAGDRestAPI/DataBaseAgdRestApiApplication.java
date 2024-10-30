package com.example.dataBaseAGDRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
		"com.example.dataBaseAGDRestAPI.appliance",
		"com.example.dataBaseAGDRestAPI.rest",
		"com.example.dataBaseAGDRestAPI.service"
})
public class DataBaseAgdRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBaseAgdRestApiApplication.class, args);
	}

}
