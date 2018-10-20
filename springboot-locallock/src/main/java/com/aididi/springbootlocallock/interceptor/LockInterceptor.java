package com.aididi.springbootlocallock.interceptor;

import com.aididi.springbootlocallock.annotation.LocalLock;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @author xuzexiang
 * @Date: 2018-9-14 0014
 * @Description:基于本地缓存 ,防止重复提交
 */
@Log4j2
@Aspect
@Configuration
public class LockInterceptor {
   private Cache<String,Object> chach  = CacheBuilder.newBuilder()
            //最大缓存1000个
            .maximumSize(1000)
            //设置写缓存后5秒钟过期
            .expireAfterAccess(5, TimeUnit.SECONDS)
            .build();

   @Around("execution(public * * (..)) && @annotation(com.aididi.springbootlocallock.annotation.LocalLock)")
    public Object interceptor(ProceedingJoinPoint pjp)  {
       MethodSignature signature = (MethodSignature) pjp.getSignature();
       Method method = signature.getMethod();
       LocalLock lock = method.getAnnotation(LocalLock.class);
       String key = getKey(lock.key(),pjp.getArgs());
       if(!StringUtils.isEmpty(key)){
           if(chach.getIfPresent(key)!=null){
               throw new RuntimeException("请勿重复提交");
           }
           //如果是第一次请求，就把key当前对象亚入缓存中
           chach.put(key,key);
       }
       try {
           return  pjp.proceed();
       } catch (Throwable throwable) {
           log.error(throwable.getMessage());
           throw new RuntimeException("运行异常");
       } finally {
           //TODO 为了演示效果,这里就不调用 CACHES.invalidate(key); 代码了
       }
   }

    /**
     * 功能描述:key 的生成策略,如果想灵活可以写成接口与实现类的方式（TODO 后续讲解）
     * @param: []
     * @return: java.lang.String
     * @auther: xuzexiang
     * @date: 2018-9-14 0014 下午 1:24
     */
    private String getKey(String keyExpress , Object[] args){
        for (int i=0;i<args.length;i++){
            keyExpress = keyExpress.replace("args["+i+"]",args[i].toString());

        }
        return keyExpress;
    }

}
