package com.care.health.ubs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class UbsHealthCareApplication {

	public static void main(String[] args) {
		SpringApplication.run(UbsHealthCareApplication.class, args);
	}
	public static List<String> loginTokens = new ArrayList<>();
}
