package com.tjx.controller;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExceptionReslover implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mav = new ModelAndView("welcome");
        if (ex instanceof ArithmeticException){
            System.out.println("ExceptionReslover-ArithmeticException");
            mav.setViewName("error/error1");
        }
        mav.addObject("ex",ex);
        return mav;
    }
}
