package easy.event.listener;

import easy.event.EastInitEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Description: the Description of this class
 * @Author: jp
 * @CreateDate: 2018年9月1日
 * @Version: ${project.version}
 */
@Slf4j
public class EasyStartListener implements ApplicationListener<ApplicationStartedEvent>{
    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info(" EasyStartListener ");
        applicationStartedEvent.getApplicationContext().publishEvent(new EastInitEvent(new Object()));
    }
}
