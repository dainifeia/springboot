package com.aididi.annotation;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author xuzexiang
 * @Date: 2018-9-24 0024
 * @Description:
 */
public interface CacheKeyGenerator {
    /**
     * 功能描述:获取AOP参数,生成指定缓存Key
     * @param: [pjp]
     * @return: java.lang.String
     * @auther: xuzexiang
     * @date: 2018-9-24 0024 上午 12:14
     */
    String getLocal(ProceedingJoinPoint pjp);

}
