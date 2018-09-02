package easy.event.listener;

import easy.event.EastInitEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description: the Description of this class
 * @Author: jp
 * @CreateDate: 2018/9/1
 * @Version: ${project.version}
 */
@Component
@Slf4j
public class EasyInitListener implements ApplicationListener<EastInitEvent> {


    @Override
    public void onApplicationEvent(EastInitEvent eastInitEvent) {
        log.info("EasyInit");
    }
}
