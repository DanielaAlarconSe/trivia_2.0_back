package com.ciber;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CiberApplication {

	public static void main(String[] args) {
		SpringApplication.run(CiberApplication.class, args);
	}

}
