package com.nown.contacts.service;

import com.nown.contacts.entity.Student;
import com.nown.contacts.entity.StudentDaoSpec;
import com.nown.contacts.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public List<Student> findByParams(Student student){
        List<Student> list = studentDao.findAll(
                StudentDaoSpec.getSpec(
                        student.getNumber(),student.getName(),
                        student.getSex(),student.getAge(),student.getBirthday(),
                        student.getTel(),student.getAddress(),
                        student.getMail(),student.getMajor()
                )
        );
        return list;
    }

    public Page<Student> findAll(PageRequest request) {
        return studentDao.findAll(request);
    }


    public Student save(Student student) {
        return studentDao.save(student);

    }

    public void save(List<Student> list){
        Iterator<Student> iterator=list.iterator();
        while (iterator.hasNext()){
            Student student= iterator.next();
            if (findByNumber(student.getNumber())==null){
                save(student);
            }else{
                System.out.println("学号已存在，未添加到数据库："+student);
            }
        }
    }

    public Student findById(Integer id) {
        return studentDao.findById(id).get();
    }

    public void deleteById(Integer id) {
        studentDao.deleteById(id);
    }

    public List<Student> findAll(){
        return studentDao.findAll();
    }

    public Student findByNumber(String number){
        return studentDao.findStudentByNumber(number);
    }

    public List<Student> findByNameLike(String name){
        return studentDao.findStudentsByNameLike("%"+name+"%");
    }
}
