package com.aididi.springsecurity.service;

import com.aididi.springsecurity.pojo.UserVo;

/**
 * @Auther: xuzexiang
 * @Date: 2018/5/25 0025 16:16
 * @Description:
 */
public interface UserService {
    /**
     * 功能描述:    插入一条记录
     * @param:
     * @return:
     * @auther: xuzexiang
     * @date: 2018/5/25 0025 下午 4:18
     */
    UserVo selectUserByname(String username);

    /**
     * 功能描述:    根据用户名称查询用户信息'
     * @param:
     * @return: 
     * @auther: xuzexiang
     * @date: 2018/5/25 0025 下午 4:18
     */
    boolean insert(UserVo userVo);

}
