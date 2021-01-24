package com.nown.contacts.service;

import com.nown.contacts.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {
    @Autowired
    StudentService service;

    @Test
    public void reset(){

        for (int i=1;i<=9;i++){
            Student student=new Student();
            student.setNumber("2020000"+i);
            student.setName("学生"+i);
            if (i%2==0){
                student.setSex("男");
            }else {
                student.setSex("女");
            }
            student.setAge(20);
            student.setBirthday("2020-01-0"+i);
            student.setTel("12345678900"+i);
            student.setAddress("江苏省徐州市铜山区");
            student.setMail("123456000"+i+"@qq.com");
            student.setMajor("专业"+(i%8+1));
            service.save(student);
        }
        for (int i=10;i<=29;i++){
            Student student=new Student();
            student.setNumber("202000"+i);
            student.setName("学生"+i);
            if (i%2==0){
                student.setSex("男");
            }else {
                student.setSex("女");
            }
            student.setAge(20);
            student.setBirthday("2020-01-"+i);
            student.setTel("1234567890"+i);
            student.setAddress("江苏省徐州市铜山区");
            student.setMail("12345600"+i+"@qq.com");
            student.setMajor("专业"+(i%8+1));
            service.save(student);
        }
    }
}