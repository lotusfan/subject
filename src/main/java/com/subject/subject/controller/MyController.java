package com.subject.subject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: MyController
 * @description:
 * @author: zhangfan
 * @data: 2018年05月26日 17:51
 */
@RestController //方法的返回都是以json输出
public class MyController {

    @RequestMapping("t")
    public String test(){
        return "success\n";
    }
}
