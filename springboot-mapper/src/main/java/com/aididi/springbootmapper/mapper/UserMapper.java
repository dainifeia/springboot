package com.aididi.springbootmapper.mapper;

import com.aididi.springbootmapper.domain.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{
    int countByUsername(String username);
}
