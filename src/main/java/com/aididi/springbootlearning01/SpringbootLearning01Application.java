package com.aididi.springbootlearning01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
@SpringBootApplication
public class SpringbootLearning01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLearning01Application.class, args);
	}

	@RequestMapping(value = "/" ,produces = "text/plain;charset=UTF-8")
	Map index(){
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("a",1);
		map.put("b",2);
		return map;
	}
}
