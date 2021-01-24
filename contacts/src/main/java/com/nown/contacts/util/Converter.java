package com.nown.contacts.util;

import com.nown.contacts.entity.Dustbin;
import com.nown.contacts.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public Student toStudent(Dustbin dustbin){
        Student student=new Student();
        student.setName(dustbin.getName());
        student.setNumber(dustbin.getNumber());
        student.setAddress(dustbin.getAddress());
        student.setAge(dustbin.getAge());
        student.setBirthday(dustbin.getBirthday());
        student.setId(dustbin.getStuid());
        student.setMail(dustbin.getMail());
        student.setMajor(dustbin.getMajor());
        student.setSex(dustbin.getSex());
        student.setTel(dustbin.getTel());
        return student;
    }

    public Dustbin toDustbin(Student student){
        Dustbin dustbin=new Dustbin();
        dustbin.setStuid(student.getId());
        dustbin.setNumber(student.getNumber());
        dustbin.setName(student.getName());
        dustbin.setAddress(student.getAddress());
        dustbin.setAge(student.getAge());
        dustbin.setBirthday(student.getBirthday());
        dustbin.setMail(student.getMail());
        dustbin.setMajor(student.getMajor());
        dustbin.setSex(student.getSex());
        dustbin.setTel(student.getTel());
        return dustbin;
    }
}
