package com.aididi.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuzexiang
 * @Date: 2018/7/8 0008
 * @Description:用户实体类
 */
@Slf4j
@Data
public class User {
    /**
     * 用户id
     */
    private Long id;
    /**
     * 城市名称
     */
    private String userName;
    /**
     * 描述
     */
    private String description;

    private City city;

}
