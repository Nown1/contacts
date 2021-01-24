package com.nown.contacts.controller;

import com.nown.contacts.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/file")
public class FileController{

    @Autowired
    private ExcelService service;

    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("学生信息", "UTF-8").replaceAll("\\+", "%20");
        System.out.println(fileName);
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        service.doWrite(response.getOutputStream());

    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        service.doRead(file);
        return "success";
    }
}
