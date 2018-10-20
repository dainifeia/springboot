package com.aididi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author xuzexiang
 * @Date: 2018/7/10 0010
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class IndexController {

    @RequestMapping(value = "/login_view",method = RequestMethod.GET)
    public String login_view() {
        return "login";
    }

   @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
