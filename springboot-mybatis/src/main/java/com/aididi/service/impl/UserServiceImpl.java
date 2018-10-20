package com.aididi.service.impl;

import com.aididi.dao.master.UserDao;
import com.aididi.dao.slave.CityDao;
import com.aididi.domain.City;
import com.aididi.domain.User;
import com.aididi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final CityDao cityDao;
    @Autowired
    UserServiceImpl(UserDao userDao,CityDao cityDao){
        this.userDao = userDao;
        this.cityDao = cityDao;
    }

    @Override
    public User findByName(String userName) {
        User user = userDao.findByName(userName);
        City city = cityDao.findByName("温岭市");
        user.setCity(city);
        return user;
    }
}
