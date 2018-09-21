package com.easy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/21 14:50
 * @Version: 1.0
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication easy = new SpringApplication(App.class);
        easy.run(args);
    }
}
