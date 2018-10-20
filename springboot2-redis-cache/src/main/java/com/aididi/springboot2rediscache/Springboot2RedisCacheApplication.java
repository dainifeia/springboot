package com.aididi.springboot2rediscache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude ={RedisAutoConfiguration.class, RedisRepositoriesAutoConfiguration.class})
public class Springboot2RedisCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot2RedisCacheApplication.class, args);
	}
}
