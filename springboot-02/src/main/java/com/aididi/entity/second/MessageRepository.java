package com.aididi.entity.second;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:
 */
public interface MessageRepository extends JpaRepository<Message,Long> {
}
