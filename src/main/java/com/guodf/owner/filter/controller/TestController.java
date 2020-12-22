package com.guodf.owner.filter.controller;

import com.guodf.owner.filter.createTarget.IgnoreAuth;
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

    /**
     * http://localhost:8080/test
     * 无token
     * @return
     */
    @IgnoreAuth
    @GetMapping("/test")
    public String Test(){
        return "该应用不应该被拦截1111111111111111111";
    }

    /**
     * http://localhost:8080/v1/aaa
     * 无token 有注解
     * @return
     */
    @IgnoreAuth
    @GetMapping("/v1/aaa")
    public String Test1(){
        return "该应用不应该被拦截333333333333333333";
    }

    /**
     * http://localhost:8080/v1/aaa1
     * 无token 无注解
     * @return
     */
    @GetMapping("/v1/aaa1")
    public String Test11(){
        return "该应用应该被拦截333333333333333333";
    }

    /**
     * http://localhost:8080/v1/bbb?token=001
     * 有token
     * @return
     */
    @GetMapping("/v1/bbb")
    public String Test2(){
        return "该应用不该被拦截222222222222222";
    }
}
