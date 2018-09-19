package com.tjx.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

public class BaseController {
    /**
     * 处理默认异常
     */
    @ExceptionHandler
    public ModelAndView defaultException(Exception ex){
        ModelAndView mv = new ModelAndView("error/error1");
        mv.addObject("ex",ex);
        return mv;
    }

    @ExceptionHandler(AgeException.class)
    public ModelAndView ageException(AgeException ex){
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("ex",ex);
        return mv;
    }

    @ExceptionHandler(ArithmeticException.class)
    public ModelAndView arithmeticException(ArithmeticException ex){
        ModelAndView mv = new ModelAndView("error/error2");
        mv.addObject("ex",ex);
        return mv;
    }

}
