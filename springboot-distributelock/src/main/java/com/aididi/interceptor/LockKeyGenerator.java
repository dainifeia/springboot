package com.aididi.interceptor;

import com.aididi.annotation.CacheKeyGenerator;
import com.aididi.annotation.CacheLock;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @author xuzexiang
 * @Date: 2018-9-24 0024
 * @Description:
 */
public class LockKeyGenerator implements CacheKeyGenerator {
    @Override
    public String getLocal(ProceedingJoinPoint pjp) {
        //获取执行的方法
       MethodSignature ms = (MethodSignature) pjp.getSignature();
        Method method = ms.getMethod();
        //获取执行方法上的注解
        CacheLock lockannotation =  method.getAnnotation(CacheLock.class);
        //获取执行方法的参数
        final Object[] args = pjp.getArgs();
        //获取执行方法上执行文件的所有参数
        final Parameter[] parameters = method.getParameters();
        StringBuilder builder = new StringBuilder();


        return null;
    }
}
