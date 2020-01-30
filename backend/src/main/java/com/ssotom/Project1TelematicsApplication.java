package com.ssotom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class Project1TelematicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Project1TelematicsApplication.class, args);
	}

}
