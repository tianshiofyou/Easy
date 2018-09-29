package com.easy;

import com.easy.context.EasyContext;
import com.easy.context.Platform;
import com.easy.event.listener.EasyStartListener;
import com.easy.netty.server.NettyServer;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

/**
 * @Description: the Description of this class
 * @Author: jp
 * @CreateDate: 2018/9/2
 * @Version: ${project.version}
 */
public class EasyApplication extends SpringApplication {

    public EasyApplication(Class... primarySources) {
        super((ResourceLoader)null, primarySources);
    }

    /*public EasyApplication(Class<?>[] primarySources) {
        super(primarySources);
    }*/

    public EasyApplication(ResourceLoader resourceLoader, Class<?>[] primarySources) {
//        super(resourceLoader, primarySources);
        this.addListeners(new EasyStartListener());
        //启动netty服务端
        this.addListeners(new NettyServer());
    }
}
