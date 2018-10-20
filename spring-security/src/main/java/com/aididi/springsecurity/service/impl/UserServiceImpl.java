package com.aididi.springsecurity.service.impl;

import com.aididi.springsecurity.mapper.UserMapper;
import com.aididi.springsecurity.pojo.UserVo;
import com.aididi.springsecurity.service.UserService;
import com.aididi.springsecurity.util.StringFinalCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Auther: xuzexiang
 * @Date: 2018/5/25 0025 16:17
 * @Description:
 */
@Service
@Primary
@Log4j2
public class UserServiceImpl implements UserService {


    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper mapper){
        this.userMapper = mapper;
    }

    @Override
    public UserVo selectUserByname(String username) {
      return userMapper.selectUserByname(username);
    }

    @Override
    public boolean insert(UserVo userVo) {
        String username  = userVo.getUsername();
        if (exist(username))
            return false;
        userVo.setRoles(StringFinalCode.ROLE_USER);
        int result = userMapper.insert(userVo);
        return result == 1;
    }

    /**
     * 功能描述:
     * @param: [username]
     * @return: boolean
     * @auther: xuzexiang
     * @date: 2018/5/25 0025 下午 4:39
     */
   public boolean exist(String username){
       UserVo userEntity = userMapper.selectUserByname(username);
       return (userEntity != null);
    }
}
