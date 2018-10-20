package com.aididi;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author xuzexiang
 * @Date: 2018/7/11 0011
 * @Description:
 */
public class ServletInlitialize extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootValidatorApplication.class);
    }
}
