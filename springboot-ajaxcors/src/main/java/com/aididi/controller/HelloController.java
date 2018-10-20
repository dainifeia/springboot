package com.aididi.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

/**
 * @author xuzexiang
 * @Date: 2018-9-12 0012
 * @Description:
 */
@Controller
@RequestMapping("/admin")
public class HelloController {

    /**
     * 功能描述:
     * @param: []
     * @return: java.lang.String
     * @auther: xuzexiang
     * @date: 2018-9-12 0012 下午 10:22
     */
    @RequestMapping(value = "/test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String query(){
        return "index";
    }
    class User{

    }
}
