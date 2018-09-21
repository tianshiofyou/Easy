package com.easy;

import com.easy.boot.EasyApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by admin on 2018/9/1.
 */
@SpringBootApplication
/*@Api("APP test")
@RestController*/
public class AppTest {
    /*@RequestMapping("/")
    @ApiOperation(value = "进入首页", notes = "输出欢迎语")
    public String welcome(){
        return "it is so easy to do";
    }*/

    public static void main(String[] args) {
        EasyApplication s = new EasyApplication(AppTest.class);
        s.run(args);
    }
}
