package com.nown.contacts.service;

import com.nown.contacts.entity.Student;
import com.nown.contacts.util.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class ExcelService  {

    @Autowired
    private Operator operator;

    @Autowired
    private StudentService studentService;

    public void doWrite(OutputStream outputStream){
        List<Student> list=studentService.findAll();
        operator.doWrite(outputStream,list);
    }

    public void doRead(MultipartFile file) throws IOException {
        operator.doRead(file);
    }
}
