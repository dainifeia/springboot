package com.aididi.dao.slave;

import com.aididi.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:
 */
@Mapper
public interface CityDao {
    /**
     * 功能描述:
     * @param: cityName
     * @return: City
     * @auther: xuzexiang
     * @date: 2018/7/8 0008 下午 11:42
     * @Description: 根据城市名称，查询城市信息
     */
    City findByName(@Param("cityName") String cityName);
}
