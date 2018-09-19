package com.tjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class FileController {
    /**
     * 单文件上传
     * @param file
     * @param session
     * @return
     */
    @RequestMapping("/add")
    public String add(MultipartFile file, HttpSession session){
        //上传后文件夹名称 upload   获取服务器地址
        String realPath = session.getServletContext().getRealPath("/upload");
        File file1 = new File(realPath);
        if (!file1.exists()){
            file1.mkdir();//创建文件夹
        }
        String filename = file.getOriginalFilename();
        try {
            //真正的文件上传到服务器中
            file.transferTo(new File(realPath,filename));
            System.out.println("文件上传大小："+file.getBytes());
            System.out.println("文件上传类型："+file.getContentType());
            System.out.println("文件名称："+filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/WEB-INF/welcome.jsp";
    }

    @RequestMapping("/add")
    public String add(@RequestParam MultipartFile[] file, HttpSession session){
        //上传后文件夹名称 upload   获取服务器地址
        String realPath = session.getServletContext().getRealPath("/upload");
        *//*File file1 = new File(realPath);
        if (!file1.exists()){
            file1.mkdir();//创建文件夹
        }*//*
        for (MultipartFile file2 : file) {
            String filename = file2.getOriginalFilename();
            try {
                //真正的文件上传到服务器中
                file2.transferTo(new File(realPath,filename));
                System.out.println("文件上传大小："+file2.getBytes());
                System.out.println("文件上传类型："+file2.getContentType());
                System.out.println("文件名称："+filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "/WEB-INF/welcome.jsp";
    }


}
