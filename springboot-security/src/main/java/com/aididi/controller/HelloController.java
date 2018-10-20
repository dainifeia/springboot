package com.aididi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzexiang
 * @Date: 2018/7/24 0024
 * @Description:
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        return  "hello";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return  "login";
    }

}
