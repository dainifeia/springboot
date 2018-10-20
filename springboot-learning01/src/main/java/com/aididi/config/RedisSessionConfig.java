package com.aididi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @Auther: xuzexiang
 * @Date: 2018/7/2 0002 11:12
 * @Description:   1. 开启redis 存储session
 *                 2. spring session 默认会代替httpsession
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 3000 )
public class RedisSessionConfig {

}
