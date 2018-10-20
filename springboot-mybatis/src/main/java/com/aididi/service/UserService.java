package com.aididi.service;

import com.aididi.domain.User;
import com.sun.org.apache.bcel.internal.generic.DDIV;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:用户业务接口层
 */
public interface UserService {
    /**
     * 功能描述:
     * @param: userName
     * @return: User
     * @auther: xuzexiang
     * @date: 2018/7/8 0008 下午 11:44
     * @Description: 根据用户名获取用户信息，包括从库的地址信息
     */
    User findByName(String userName);
}
