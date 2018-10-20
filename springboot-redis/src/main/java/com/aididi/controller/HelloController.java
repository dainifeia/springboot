package com.aididi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @author xuzexiang
 * @Date: 2018/7/24 0024
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/uid")
    public String uuid(HttpSession session){
        UUID uuid  = (UUID) session.getAttribute("uid");
        if(uuid == null){
            uuid = UUID.randomUUID();
        }
        session.setAttribute("uid",uuid);
        return session.getId();
    }
}
