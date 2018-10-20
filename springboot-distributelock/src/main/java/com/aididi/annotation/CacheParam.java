package com.aididi.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * @author xuzexiang
 * @Date: 2018-9-24 0024
 * @Description:    锁的参数  key 的生成规则是自己定义的
 */
@Documented
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
public @interface CacheParam {
    /**
     * 功能描述:字段名称
     * @param: []
     * @return: java.lang.String
     * @auther: xuzexiang
     * @date: 2018-9-24 0024 上午 12:08
     */
    String name() default "";
    
}
