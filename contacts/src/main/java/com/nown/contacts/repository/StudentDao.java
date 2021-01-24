package com.nown.contacts.repository;

import com.nown.contacts.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> ,
        JpaSpecificationExecutor<Student> {

    Student findStudentByNumber(String number);
    List<Student> findStudentsByNameLike(String name);
}
