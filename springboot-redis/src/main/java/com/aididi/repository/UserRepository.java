package com.aididi.repository;

import com.aididi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @author xuzexiang
 * @Date: 2018/7/25 0025
 * @Description:
 */
@Component
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String userName,String email);
}
