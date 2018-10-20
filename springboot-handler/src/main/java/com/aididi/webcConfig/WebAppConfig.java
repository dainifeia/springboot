package com.aididi.webcConfig;


import com.aididi.handle.InterceptorConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author xuzexiang
 * @Date: 2018/7/9 0009
 * @Description:  springboot2.0废弃了WebMvcConfigurerAdapter ，要想实现拦截器可继承WebMvcConfigurationSupport或实现WebMvcConfigurer
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**");
    }
}