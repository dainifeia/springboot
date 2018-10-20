package com.aididi.service;

import com.aididi.entity.UserEntity;

import java.util.List;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
public interface UserService {
    /**
     * 功能描述: 
     * @param: 
     * @return: com.aididi.entity.UserEntity
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 上午 12:38
     */
    List<UserEntity> findAllUser();
    /**
     * 功能描述: 
     * @param:
     * @return: com.aididi.entity.UserEntity
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 上午 12:39
     */
    List<UserEntity> findUserById(String name);
}
