package com.easy.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Objects;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/4 18:08
 * @Version: 1.0
 */
public class Json {

    public static String toJsonString(Object t){
        if (Objects.isNull(t)) {
            return "";
        }
        return JSON.toJSONString(t);
    }

    public static <T> T parse(String json){
        return JSON.parseObject(json, new TypeReference<T>() {});
    }

}
