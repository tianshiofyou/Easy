package com.easy.context;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/8/31 16:35
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix="easy.platform")
@PropertySource("easy.properties")
public class Platform {

    private String name;

    private String version;

    private String address;

    private String description;

}
