package com.easy;

import com.easy.EasyApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/21 14:50
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.easy.user.mapper")
public class App {
    public static void main(String[] args) {
        EasyApplication easy = new EasyApplication(App.class);
        easy.run(args);
    }
}
