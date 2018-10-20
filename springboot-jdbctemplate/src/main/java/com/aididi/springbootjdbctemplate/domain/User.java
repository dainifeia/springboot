package com.aididi.springbootjdbctemplate.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;


    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }
}
