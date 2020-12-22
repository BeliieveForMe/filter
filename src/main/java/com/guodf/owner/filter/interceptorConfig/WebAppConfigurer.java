package com.guodf.owner.filter.interceptorConfig;

import com.guodf.owner.filter.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

/**
 * @ClassName WebAppConfigurer 全量解析，仅作参考未使用
 * @description:
 * @author: BeliieveForMe-GuoDF
 * @Email: 731998663@qq.com
 * @date: Created in 2020/12/22 16:05
 * @Version 1.0.0
 */
@Configuration
public class WebAppConfigurer implements WebMvcConfigurer {

    public WebAppConfigurer() {
    }

    /**
     * 针对访问路径的各种配置修改，一般没有特殊情况不做修改
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    }
    /**
     * 内容协商机制，主要是方便一个请求路径返回多个数据格式。
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {

    }

    /**
     * 异步配置  超时时间，异步任务执行器配置
     * @param configurer
     */
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {

    }

    /**
     *
     * @param configurer
     */

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {

    }

    /**
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {

    }

    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }

    /**
     * 静态资源处理
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }

    /**
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {

    }

    /**
     * 视图跳转控制器
     * 以前要访问一个页面需要先创建个Controller控制类，再写方法跳转到页面
     * 在这里配置后就不需要那么麻烦了，直接访问http://localhost:8080/toLogin就跳转到login.jsp页面了
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/toLogin").setViewName("login");
    }

    /**
     * 这里配置视图解析器
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    /**
     *
     * @param resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

    }

    /**
     *
     * @param handlers
     */
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {

    }

    /**
     *
     * @param converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

    }

    /**
     *
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    /**
     *
     * @param resolvers
     */
    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {

    }

    /**
     *
     * @return
     */
    @Override
    public Validator getValidator() {
        return null;
    }

    /**
     *
     * @return
     */
    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
