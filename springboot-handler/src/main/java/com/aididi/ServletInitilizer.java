package com.aididi;

import com.aididi.SpringbootHandlerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author xuzexiang
 * @Date: 2018/7/9 0009
 * @Description:
 */
public class ServletInitilizer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringbootHandlerApplication.class);
    }
}
