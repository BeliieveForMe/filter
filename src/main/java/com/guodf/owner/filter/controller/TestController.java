package com.guodf.owner.filter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**

/**
 * @ClassName TestController
 * @Description TOOD
 * @Author Administrator
 * @Date 2020/12/2211:44
 * @Version 1.0
 **/
@RestController
public class TestController {

    @GetMapping("/test")
    public String Test(){
        return "测试该工程是否可用";
    }
}
