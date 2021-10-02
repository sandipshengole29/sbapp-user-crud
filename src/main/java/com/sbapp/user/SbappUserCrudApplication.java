package com.sbapp.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SbappUserCrudApplication {

	public static void main(String[] args) {
		final Logger LOGGER = LoggerFactory.getLogger(SbappUserCrudApplication.class);
		
		LOGGER.info("***====*** Starting spring boot application for USER CRUD Operation ***====***");
		SpringApplication.run(SbappUserCrudApplication.class, args);
	}

}
