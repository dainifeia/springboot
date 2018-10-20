package com.aididi.controller;

import com.aididi.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author xuzexiang
 * @Date: 2018-10-16 0016
 * @Description:
 */
@RestController
@RequestMapping("/index")
public class UserController {

    @GetMapping
    public User query(){
        User user = new User();
        user.setTimer(LocalDateTime.now());
        return user;
    }

}
