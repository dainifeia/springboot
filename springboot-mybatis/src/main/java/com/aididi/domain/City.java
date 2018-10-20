package com.aididi.domain;

import lombok.Data;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:城市实体类
 */
@Data
public class City {
    /**
     * 城市编号
     */
    private Long id;
    /**
     * 省份编号
     */
    private Long provinceId;
    /**
     * 城市名称
     */
    private String cityName;
    /**
     * 描述
     */
    private String description;

}
