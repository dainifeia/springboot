package com.aididi.dao.master;

import com.aididi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:  用户 DAO 接口类
 */
@Mapper
public interface UserDao {
/**
 * 功能描述:
 * @param: userName
 * @return: User
 * @auther: xuzexiang
 * @date: 2018/7/8 0008 下午 11:42
 * @Description: 根据用户名获取用户信息
 */
    User findByName(@Param("userName") String userName);

}
