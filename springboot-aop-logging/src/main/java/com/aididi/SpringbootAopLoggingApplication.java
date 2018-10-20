package com.aididi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbootAopLoggingApplication {

	public static void main(String[] args) {
       /* SpringApplication app = new SpringApplication(SpringbootAopLoggingApplication.class);
        app.setAdditionalProfiles("prod");
        app.run(args);*/
        SpringApplication.run(SpringbootAopLoggingApplication.class, args);
	}
}
