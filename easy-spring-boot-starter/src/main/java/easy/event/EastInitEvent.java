package easy.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: the Description of this class
 * @Author: jp
 * @CreateDate: ${date}
 * @Version: ${project.version}
 */
public class EastInitEvent extends ApplicationEvent{

    public EastInitEvent(Object source) {
        super(source);
    }

}
