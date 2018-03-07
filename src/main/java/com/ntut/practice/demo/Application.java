package com.ntut.practice.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 此為 Spring boot application , 執行此程式開啟應用程式
public class Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		LOGGER.info("Start up spring boot application, powered by KB");
		SpringApplication.run(Application.class, args);
		LOGGER.debug("SpringApplication is running");
	}
	
}
