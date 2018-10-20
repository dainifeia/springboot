package com.aididi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author xuzexiang
 * @Date: 2018-9-12 0012
 * @Description:  自定义的请求信息，拦截http请求
 */
@Configuration
public class CorsConfigOtherOne {


    private CorsConfiguration buildCofig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //允许任何请求头
        corsConfiguration.addAllowedHeader("*");
        //允许任何域名跨域
        corsConfiguration.addAllowedOrigin("*");
        //允许任何方法（post、get等）
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }
    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource cors = new UrlBasedCorsConfigurationSource();
        cors.registerCorsConfiguration("/**",buildCofig());
        return new CorsFilter(cors);
    }
}
