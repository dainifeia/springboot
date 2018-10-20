package com.aididi.springbootjdbctemplate;

import com.aididi.springbootjdbctemplate.service.EnviromentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootJdbctemplateApplication {

	public static void main(String[] args) {
		ApplicationContext act = (ApplicationContext)SpringApplication.run(SpringbootJdbctemplateApplication.class, args);
		EnviromentService service =  act.getBean(EnviromentService.class);
		service.print();
		Object name = act.getBean("cmdService");
		System.out.println("是否存在："+name.toString());
	}
}
