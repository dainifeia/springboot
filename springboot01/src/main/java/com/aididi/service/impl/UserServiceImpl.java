package com.aididi.service.impl;

import com.aididi.entity.UserEntity;
import com.aididi.mapper.UserMapper;
import com.aididi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public List<UserEntity> findAllUser() {
        return userMapper.findAll();
    }

    @Override
    public List<UserEntity> findUserById(String name) {
        return userMapper.findUserById(name);
    }
}
