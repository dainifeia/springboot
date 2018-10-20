package com.aididi.springbootjdbctemplate.config;

import com.aididi.springbootjdbctemplate.conditional.LinuxConditional;
import com.aididi.springbootjdbctemplate.conditional.WindowConditional;
import com.aididi.springbootjdbctemplate.service.EnviromentService;
import com.aididi.springbootjdbctemplate.service.impl.LinuxService;
import com.aididi.springbootjdbctemplate.service.impl.WindowService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author xuzexiang
 * @Date: 2018/8/27 0027
 * @Description:
 */
@Configuration
public class EnviromentConfig {

    /**
     * 当在window环境时，WindowConditional的matches方法返回true，WindowService会被注入
     * @return
     */
    @Bean("cmdService")
    @Conditional(WindowConditional.class)
    public EnviromentService windowService(){
        return new WindowService();
    }

    /**
     * 当在linux环境时，LinuxConditional的matches方法返回true，LinuxService会被注入
     * @return
     */
    @Bean("cmdService")
    @Conditional(LinuxConditional.class)
    public EnviromentService linuxService(){
        return new LinuxService();
    }

}
