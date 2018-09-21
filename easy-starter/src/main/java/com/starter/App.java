package com.starter;

import com.easy.boot.EasyApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/21 17:07
 * @Version: 1.0
 */
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        EasyApplication stater = new EasyApplication(App.class);
        stater.run(args);
    }

}
