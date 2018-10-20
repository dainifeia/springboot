package com.aididi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 * @param:
 * @return:
 * @auther: xuzexiang
 * @date: 2018/7/3 0003 下午 10:04
 */
@RestController
@SpringBootApplication
public class Springboot01Application {

    @RequestMapping(value = "/index")
    public String hello(){
        return "hello world!!!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Springboot01Application.class,args);
    }
}
