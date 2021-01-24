package com.nown.contacts.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.nown.contacts.entity.Student;
import com.nown.contacts.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Component
public class Operator {

    @Autowired
    StudentService studentService;

    public  void doWrite(OutputStream outputStream, List<Student> list){
        EasyExcel.write(outputStream, Student.class).sheet("模板").doWrite(list);

    }

    public void doRead(MultipartFile file) throws IOException {

        EasyExcel.read(file.getInputStream(), Student.class, new ExcelListener(studentService)).sheet().doRead();

    }


}

