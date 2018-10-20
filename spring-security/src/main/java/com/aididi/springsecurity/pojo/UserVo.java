package com.aididi.springsecurity.pojo;

import lombok.Data;

/**
 * @Auther: xuzexiang
 * @Date: 2018/5/25 0025 15:19
 * @Description:
 */
@Data
public class UserVo {
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 权限
     */
    private String roles;
}
