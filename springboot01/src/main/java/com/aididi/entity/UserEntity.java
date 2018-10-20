package com.aididi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xuzexiang
 * @Date: 2018/7/4 0004 15:01
 * @Description:
 */
@Data
public class UserEntity implements Serializable{
    private String id;
    private String name;
    private String nickName;
}
