package com.subject.subject.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @title: MyModel
 * @description:
 * @author: zhangfan
 * @data: 2018年05月29日 18:03
 */
@ConfigurationProperties(prefix = "model")
@PropertySource("classpath:self.properties")
public class MyModel {

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
