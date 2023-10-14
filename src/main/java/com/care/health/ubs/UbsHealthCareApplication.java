package com.care.health.ubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class UbsHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsHealthCareApplication.class, args);
	}

}
