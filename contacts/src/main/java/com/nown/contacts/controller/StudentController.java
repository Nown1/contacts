package com.nown.contacts.controller;


import com.nown.contacts.entity.Student;
import com.nown.contacts.repository.DustbinDao;
import com.nown.contacts.service.StudentService;
import com.nown.contacts.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private DustbinDao dustbinDao;

    @Autowired
    private Converter converter;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Student> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return studentService.findAll(request);
    }

    @PostMapping("/save")
    public String save(@RequestBody Student student){
        System.out.println(student);
        if (studentService.findByNumber(student.getNumber())!=null){
            return "学号已存在！";
        }
        Student result = studentService.save(student);
        if(result != null){
            return "保存成功！";
        }
            return "保存失败！";

    }

    @GetMapping("/findById/{id}")
    public Student findById(@PathVariable("id") Integer id){
        System.out.println(new Date()+";"+id);
        return studentService.findById(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody Student student){
        System.out.println(student);
        Student result = studentService.save(student);
        if(result != null){
            return "修改成功！";
        }else{
            return "修改失败！";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        System.out.println("删除操作"+new Date());
        dustbinDao.save(converter.toDustbin(studentService.findById(id)));
        studentService.deleteById(id);
    }

    @PostMapping("/search")
    public List<Student> search(@RequestBody Student student){
        System.out.println(student);
        List<Student> list=studentService.findByParams(student);
        Iterator<Student> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println("查找的数据是："+iterator.next());
        }
        return studentService.findByParams(student);
    }

    @GetMapping("/findLike/{name}")
    public List<Student> findLike(@PathVariable("name") String name){
        System.out.println(name);
//        return studentService.findByNameLike(name);
        List<Student> list=studentService.findByNameLike(name);
        Iterator<Student> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        return list;
    }

    @GetMapping("/findByNum/{num}")
    public String findByNum(@PathVariable("num") String num){
        System.out.println(num);
        Student student=studentService.findByNumber(num);
        if (student!=null){
            return "已存在";
        }
        return "不存在";
    }
}
