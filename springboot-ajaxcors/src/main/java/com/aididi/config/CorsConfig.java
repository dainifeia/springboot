package com.aididi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author xuzexiang
 * @Date: 2018-9-12 0012
 * @Description:    解决ajax支持跨域  使用拦截器
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer{
    static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE","OPTIONS"};
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*").allowCredentials(true).allowedMethods(ORIGINS).maxAge(3600);
    }
}
