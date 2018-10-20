package com.aididi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzexiang
 * @Date: 2018/7/9 0009
 * @Description:
 */
@RestController
public class WebController {

    @RequestMapping(value = "/web",method = RequestMethod.GET)
    public String hello(String name){
        return "htllo :" + name;
    }

}
