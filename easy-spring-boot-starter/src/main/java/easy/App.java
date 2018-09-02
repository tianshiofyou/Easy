package easy;

import easy.event.listener.EasyStartListener;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2018/9/1.
 */
@SpringBootApplication
/*@Api("APP test")
@RestController*/
public class App {
    /*@RequestMapping("/")
    @ApiOperation(value = "进入首页", notes = "输出欢迎语")
    public String welcome(){
        return "it is so easy to do";
    }*/

    public static void main(String[] args) {
        SpringApplication s = new SpringApplication(App.class);
        s.addListeners(new EasyStartListener());
        s.run(args);
    }
}
