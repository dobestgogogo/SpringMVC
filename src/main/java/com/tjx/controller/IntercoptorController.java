package com.tjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/intercoptor")
public class IntercoptorController {

    @RequestMapping("/a")
    public String best(){
        System.out.println("Step3：进入intercoptorController");
        return "/WEB-INF/welcome.jsp";
    }
}
