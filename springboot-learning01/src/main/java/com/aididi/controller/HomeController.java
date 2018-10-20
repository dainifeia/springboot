package com.aididi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HomeController {

	@RequestMapping(value="index")
	@ApiIgnore
	public String index() {
		return "hello world";
	}



}
