package com.tjx.controller;

import com.tjx.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/student")
public class StudentController {

   /* @RequestMapping("/hello")
    public String hello(HttpServletRequest request){
        System.out.println(request.getAttribute("id"));
        System.out.println(request.getAttribute("name"));
        System.out.println("进入student-hello");
        return "redirect:/welcome1.jsp";
    }*/


    /**
     * 校验
     *
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(@Validated User user, BindingResult result) {
        ModelAndView mv = new ModelAndView("/WEB-INF/welcome.jsp");
        if (result.hasErrors()) {
            if (result.getFieldError("id") != null) {
                mv.addObject("idError", result.getFieldError("id").getDefaultMessage());
            }
            if (result.getFieldError("name") != null) {
                mv.addObject("nameError", result.getFieldError("name").getDefaultMessage());
            }
            if (result.getFieldError("sex") != null) {
                mv.addObject("sexError", result.getFieldError("sex").getDefaultMessage());
            }
            if (result.getFieldError("email") != null) {
                mv.addObject("emailError", result.getFieldError("email").getDefaultMessage());
            }
            mv.setViewName("/index.jsp");
        }
        return mv;

    }
}
