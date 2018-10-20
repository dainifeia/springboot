package com.aididi.springsecurity.mapper;

import com.aididi.springsecurity.pojo.UserVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Auther: xuzexiang
 * @Date: 2018/5/25 0025 15:20
 * @Description:
 */
@Mapper
@Component
public interface UserMapper {
    /**
     * 功能描述: 插入一条记录
     * @param:
     * @return:
     * @auther: xuzexiang
     * @date: 2018/5/25 0025 下午 4:14
     */
    @Insert("insert into user(username,password,nickname,roles) values (#{username},#{password},#{nickname},#{roles})")
    int insert(UserVo userVo);


    /**
     * 功能描述:根据用户名称查询用户信息'
     * @param: [username]
     * @return: com.aididi.springsecurity.pojo.UserVo
     * @auther: xuzexiang
     * @date: 2018/5/25 0025 下午 4:14
     */
    @Select("select * from user where username = #{username}")
    UserVo selectUserByname(@Param("username") String username);

}
