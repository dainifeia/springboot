package com.aididi.dao;

import com.aididi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author xuzexiang
 * @Date: 2018/7/3 0003 23:33
 * @Description:
 */
public interface UserDao extends JpaRepository<UserEntity,Integer> {

}
