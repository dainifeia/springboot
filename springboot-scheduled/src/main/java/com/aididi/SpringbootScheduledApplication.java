package com.aididi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * 功能描述:
 * @auther: xuzexiang
 * @date: 2018/7/9 0009 下午 4:36
 * @Description: springboot应用启动类
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootScheduledApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootScheduledApplication.class, args);
	}



}
