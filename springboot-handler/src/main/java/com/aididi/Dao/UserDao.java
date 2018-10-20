package com.aididi.Dao;

import com.aididi.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @author xuzexiang
 * @Date: 2018/7/10 0010
 * @Description:
 */
public interface UserDao extends JpaRepository<UserEntity,Long>,JpaSpecificationExecutor<UserEntity>,Serializable {
}
