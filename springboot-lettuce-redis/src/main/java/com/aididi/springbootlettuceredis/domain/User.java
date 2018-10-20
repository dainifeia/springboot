package com.aididi.springbootlettuceredis.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 8655851615465363473L;
    private Long id;
    private String username;
    private String password;

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
}
