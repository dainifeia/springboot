package com.aididi.controller;

import com.aididi.entity.UserEntity;
import com.aididi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<UserEntity> findAllUser(){
        return userService.findAllUser();
    }
}
