package com.aididi.springbootlettuceredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
public class SpringbootLettuceRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLettuceRedisApplication.class, args);
	}
}
