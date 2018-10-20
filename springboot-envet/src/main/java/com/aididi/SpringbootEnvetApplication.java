package com.aididi;

import com.aididi.config.MyApplicationEvent;
import com.aididi.config.MyapplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootEnvetApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringbootEnvetApplication.class);
		app.addListeners (new MyapplicationListener());
		ConfigurableApplicationContext ctx = app.run(args);
		ctx.publishEvent(new MyApplicationEvent(new Object()));
		ctx.close();
		//SpringApplication.run(SpringbootEnvetApplication.class, args);
	}
}
