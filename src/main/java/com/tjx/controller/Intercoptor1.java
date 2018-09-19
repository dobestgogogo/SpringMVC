package com.tjx.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Intercoptor1 implements HandlerInterceptor {
    /**
     * 返回false：表示执行完preHandle后，后续的拦截器和处理器都不执行
     * 返回true：表示必须执行afterCompletion（）方法
     * @param request
     * @param response
     * @param handler  将要执行的controller
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Step1：进入拦截器1preHandel");
        String id = request.getParameter("id");
        if (id!=null && !id.equals("")){
            System.out.println("获取的参数id=="+id);
            request.setAttribute("id",id);
            return true;
        }
        return false;
    }

    /**
     *
     * @param request
     * @param response
     * @param handler 执行过的controller
     * @param modelAndView 执行过的controller的返回值
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Step5：进入拦截器1postHandle");
    }

    /**
     *
     * @param request
     * @param response
     * @param handler 处理核心控制器后的controller4+
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Step7：进入拦截器1afterCompletion");
    }
}
