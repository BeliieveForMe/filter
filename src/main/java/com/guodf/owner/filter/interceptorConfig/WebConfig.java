package com.guodf.owner.filter.interceptorConfig;

import com.guodf.owner.filter.interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @description:
 * @author: BeliieveForMe-GuoDF
 * @Email: 731998663@qq.com
 * @date: Created in 2020/12/22 16:53
 * @Version 1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    //将tokenInterceptor放入到spring容器中管理
    @Autowired
    public TokenInterceptor tokenInterceptor;

    /**实现此方法添加拦截器
     * /v1/*  添加拦截路径
     * /test/*  该路径下不进行拦截
     * 实际生产中，此处可配置全量拦截即可
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截路径，表示此路径下的所有地址都会先执行此拦截器，通过之后才能访问Controller
        String[] addPathPatterns = {"/v1/*"};
        String[] exportPathPatterns = {"/test/*"};
        registry.addInterceptor(tokenInterceptor).addPathPatterns(addPathPatterns).excludePathPatterns(exportPathPatterns);
    }
}