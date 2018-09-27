package com.easy.config;

import com.easy.context.EasyContext;
import com.easy.context.Platform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/26 10:00
 * @Version: 1.0
 */
@Configuration
public class EasyConfiguration {


    @Bean
    public Platform getPlatform(){
        return new Platform();
    }

    @Bean
    public EasyContext getEasyContext(){
        EasyContext easyContext = new EasyContext();
        easyContext.setPlatform(getPlatform());
        return easyContext;
    }

}
