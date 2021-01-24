package com.nown.contacts.controller;

import com.nown.contacts.entity.Dustbin;
import com.nown.contacts.entity.Student;
import com.nown.contacts.repository.DustbinDao;
import com.nown.contacts.service.StudentService;
import com.nown.contacts.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/dustbin")
public class DustbinController {

    @Autowired
    DustbinDao dustbinDao;
    @Autowired
    StudentService studentService;
    @Autowired
    Converter converter;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Dustbin> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return dustbinDao.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student){
        System.out.println(student);
        Student result = dustbinDao.save(student);
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @GetMapping("/findById/{id}")
    public Dustbin findById(@PathVariable("id") Integer id){
        System.out.println(new Date()+";"+id);
        return dustbinDao.findById(id).get();
    }


    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){

        dustbinDao.deleteById(id);
    }

    @GetMapping("/recover/{id}")
    public String recover(@PathVariable("id") Integer id){
        Student result=studentService.save(converter.toStudent(dustbinDao.findById(id).get()));
        if (result!=null){
            dustbinDao.deleteById(id);
            return "success";
        }
        return "failed";
    }

}
