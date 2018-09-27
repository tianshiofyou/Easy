package com.easy.config;

import javax.sql.DataSource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/26 10:47
 * @Version: 1.0
 */

@Configuration
public class DruidConfiguration {

    @Bean
    public DataSource dataSource(Environment environment) {
        System.out.println("DataSource");
        System.out.println(environment.getProperty("spring.datasource.druid.url"));
        return DruidDataSourceBuilder
                .create()
                .build(environment, "spring.datasource.druid");
    }


}