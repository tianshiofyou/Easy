package com.easy.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/8/31 16:35
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix="easy.platform")
@PropertySource("easy.properties")
@Component
public class Platform {

    private String name;

    private String version;

    private String address;

    private String description;

}
