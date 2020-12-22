package com.guodf.owner.filter.interceptor;

import com.guodf.owner.filter.createTarget.IgnoreAuth;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TokenInterceptor
 * @description: 针对未获取token的访问进行定向拦截
 * @author: BeliieveForMe-GuoDF
 * @Email: 731998663@qq.com
 * @date: Created in 2020/12/22 14:47
 * @Version 1.0.0
 */
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Value("${user.id1}")
    private String id1;
    @Value("${user.id1}")
    private String id2;
    @Value("${user.token1}")
    private String token1;
    @Value("${user.token2}")
    private String token2;


    public TokenInterceptor() {
        super();
    }

    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

    /**
     * 1、重写，在请求进入handler之前进行拦截，符合当前场景
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //使用注解
        IgnoreAuth ignoreAuth;
        //1： 判断是否方法级别的
        if (handler instanceof HandlerMethod) {
            ignoreAuth = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        } else {
            // 如果不是方法级别的
            return true;
        }
        if (ignoreAuth != null) {
            // 有注解,则不验证token
            return true;
        }
        //2:header中拿token
        String token = request.getParameter("token");
        if (StringUtils.isBlank(token)) {
            // 没有从request中拿
            token = request.getParameter("token");
        }

        //3:token为空
        if (StringUtils.isBlank(token)) {
            System.out.println("token 为空，无法通过拦截器");
            return false;
        }

        //4、此处模拟用户注册表来查询用户token
        Map userMap = new HashMap();
        userMap.put(token1, id1);
        userMap.put(token2, id2);

        if(userMap.containsKey(token)){
            System.out.println("您好，登录用户id为 ："+ userMap.get(token));
            request.setAttribute("userid", userMap.get(token));
            return true;
        }else{
            return false;
        }

    }

    //
//    /**
//     * 在请求处理之前执行，主要用于权限验证、参数过滤等
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//        logger.info("CustomInterceptor ==> preHandle method: do request before");
//        return true;
//    }
//
//    /**
//     * 当前请求进行处理之后执行，主要用于日志记录、权限检查、性能监控、通用行为等
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//                           ModelAndView modelAndView) throws Exception {
//        logger.info("CustomInterceptor ==> postHandle method: do request after");
//    }
//
//    /**
//     * 当前对应的interceptor的perHandle方法的返回值为true时,postHandle执行完成并渲染页面后执行，主要用于资源清理工作
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//            throws Exception {
//        logger.info("CustomInterceptor ==> afterCompletion method: do request finshed");
//    }
}
