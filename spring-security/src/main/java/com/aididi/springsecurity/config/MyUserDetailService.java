package com.aididi.springsecurity.config;

import com.aididi.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Auther: xuzexiang
 * @Date: 2018/5/25 0025 16:57
 * @Description:
 */
@Service
public class MyUserDetailService implements UserDetailsService{

    private final UserService userService;

    @Autowired
    MyUserDetailService(UserService userService){
        this.userService=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
