package com.aididi.mapper;

import com.aididi.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xuzexiang
 * @Date: 2018/7/4 0004
 * @Description:
 */
@SuppressWarnings("ALL")
@Mapper
@Component
public interface UserMapper {
    /**
     * 功能描述:
     * @param: []
     * @return: com.aididi.entity.UserEntity
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 上午 12:23
     */
    @Select("SELECT * FROM USER")
    List<UserEntity> findAll();

    /**
     * 功能描述:
     * @param: [name]
     * @return: com.aididi.entity.UserEntity
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 上午 12:23
     */
    @Select("SELECT * FROM USER WHERE USER = #{name}")
    List<UserEntity> findUserById(@Param("name") String name);

}
