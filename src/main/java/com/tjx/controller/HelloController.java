package com.tjx.controller;

import com.tjx.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;
import java.sql.SQLException;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class HelloController extends BaseController{

    //如果在这个注解中只有一个属性 value可省略
    /*@RequestMapping(value = "/**.hello/{method}/{id}")
    public ModelAndView hello(@PathVariable String method,@PathVariable int id,User user){
        System.out.println("USER==>"+user);
        System.out.println("method----->"+method);
        System.out.println("id--------->"+id);
        //设置视图名称
        ModelAndView mav = new ModelAndView("welcome");
        //将对象放进ModelAndView中，request作用域中
        mav.addObject("user",user);
        System.out.println("进入hello！");
        return mav;
    }*/

    /**
     * 转发
     * @param id
     * @param request
     * @return
     */
    /*@RequestMapping(value = "/add/{id}")
    public String add(@PathVariable int id,HttpServletRequest request){
        System.out.println(id);
        request.setAttribute("id",id);
        //return "forward:/WEB-INF/welcome.jsp"
        return "forward:/user/a.update";
    }

    @RequestMapping(value = "/*.update")
    public String update(HttpServletRequest request){
        System.out.println("add中id=="+request.getAttribute("id"));
        request.setAttribute("name","大大");
        //return "forward:/student/hello";
        return "forward:/WEB-INF/welcome.jsp";
    }*/

    /**
     * 重定向
     * @param id
     * @param request
     * @return
     */
    /*@RequestMapping(value = "/add/{id}")
    public String add(@PathVariable int id,HttpServletRequest request){
        System.out.println(id);
        request.setAttribute("id",id);
        return "redirect:/user/b.update";
    }

    @RequestMapping(value = "/*.update")
    public String update(HttpServletRequest request){
        System.out.println("add中id=="+request.getAttribute("id"));
        request.setAttribute("name","大大");
        return "redirect:/student/hello";
    }*/


    /**
     * 异常
     * @param name
     * @param password
     * @param model
     * @return
     * @throws Exception
     */
    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String name, String password, Model model) throws Exception{
        System.out.println("进入--“Login”");
        System.out.println(1/0);
        //模拟异常
        if(true){
            System.out.println("进入模拟异常");
            throw new AgeException("*********年龄异常********");
        }
        //model.addAttribute("name",name).addAttribute("password",password);
        return "welcome";
    }*/

    /**
     * 类型转换器、属性编辑器
     * @param birth
     * @return
     */
    @RequestMapping(value = "/best")
    public String best(Date birth){
        System.out.println(2);
        System.out.println(birth);
        return "welcome";
    }

    @InitBinder
    public void initBinder(WebDataBinder wdb){
        System.out.println(1);
        wdb.registerCustomEditor(Date.class,new Editor());
    }
}
