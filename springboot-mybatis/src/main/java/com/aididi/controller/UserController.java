package com.aididi.controller;

import com.aididi.domain.User;
import com.aididi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:
 */
@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/api/user",method = RequestMethod.GET)
    @ResponseBody
    public User findByName(@RequestParam(value = "userName",required = true) String userName){
       return userService.findByName(userName);
    }
}
