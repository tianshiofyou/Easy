package com.easy.user.event.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/29 19:29
 * @Version: 1.0
 */
@Slf4j
@Component
public class UserStartEventNotify {


    @EventListener
    public void processBlackListEvent(ApplicationStartedEvent event) {
        // notify appropriate parties via notificationAddress...
        log.info("~~~~~~~Easy-User module Start~~~~~~~");
    }
}
