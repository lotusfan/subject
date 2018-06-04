package com.subject.subject;

import com.subject.subject.model.MyModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @title: CustomPropertiesTest
 * @description:
 * @author: zhangfan
 * @data: 2018年05月29日 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomPropertiesTest {


    @Autowired
    MyModel model;

    @Test
    public void print() {

        System.out.println(model.getName());
    }



}
