package com.easy.event.listener;

import com.easy.event.EastInitEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description: the Description of this class
 * @Author: jp
 * @CreateDate: 2018年9月1日
 * @Version: ${project.version}
 */
@Slf4j
@Component
public class EasyStart {

    @EventListener
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info(" EasyStartListener ");
        applicationStartedEvent.getApplicationContext().publishEvent(new EastInitEvent(new Object()));
    }

}
