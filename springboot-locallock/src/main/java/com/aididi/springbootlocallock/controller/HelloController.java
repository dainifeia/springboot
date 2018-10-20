package com.aididi.springbootlocallock.controller;

import com.aididi.springbootlocallock.annotation.LocalLock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuzexiang
 * @Date: 2018-9-14 0014
 * @Description:
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    @LocalLock(key = "book:arg[0]")
    public String query(@RequestParam String token ){
        return  "success:"+token;
    }


}
