package com.easy.base.entity;

/**
 * @Description: Description
 * @Author: jp
 * @CreateDate: 2018/9/20 18:28
 * @Version: 1.0
 */
public class Model {

    private Long id;

    public Model() {
    }

    public Long getId() {
        return this.id;
    }

    public Object getKey() {
        return this.getId();
    }
}
