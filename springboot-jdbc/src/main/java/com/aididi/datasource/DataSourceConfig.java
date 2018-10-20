package com.aididi.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author xuzexiang
 * @Date: 2018/7/5 0005
 * @Description:    springboot多数据源配置类
 */
@Configuration
public class DataSourceConfig {
    /**
     * 功能描述:
     * @param: []
     * @return: javax.sql.DataSource
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 下午 3:39
     *  主库配置
     */
    @Bean(name = "primaryDataSource")
    @Primary
    @Qualifier("primaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * 功能描述:
     * @param: []
     * @return: javax.sql.DataSource
     * @auther: xuzexiang
     * @date: 2018/7/5 0005 下午 3:39
     *  从库配置
     */
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource(){

        return DruidDataSourceBuilder.create().build();
    }

    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource")  DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
