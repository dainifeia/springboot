package com.aididi.entity.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor{
}
