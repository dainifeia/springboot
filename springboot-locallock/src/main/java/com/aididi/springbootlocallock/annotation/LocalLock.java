package com.aididi.springbootlocallock.annotation;

import java.lang.annotation.*;

/**
 * @author xuzexiang
 * @Date: 2018-9-14 0014
 * @Description:    自定义注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LocalLock {
    /**
     *  放入缓存的 key
     * @return
     */
    String key() default "";
}
