package com.easy.context;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/8/31 15:55
 * @Version: 1.0
 */
@ConfigurationProperties(prefix="easy.context")
@PropertySource(value = "easy.properties")
@Data
@Component
public class EasyContext {

    private String profile;

    private String language;

    private String[] constants;

    @Autowired
    private Platform platform;

    private Map<String,Object> setting = new ConcurrentHashMap<>();

    public Object get(String key){
        return setting.get(key);
    }

    public Object set(String key, Object value){
        return setting.putIfAbsent(key,value);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"profile\":\"")
                .append(profile).append('\"');
        sb.append(",\"language\":\"")
                .append(language).append('\"');
        sb.append(",\"constants\":")
                .append(Arrays.toString(constants));
        sb.append(",\"setting\":")
                .append(setting);
        sb.append('}');
        return sb.toString();
    }
}
