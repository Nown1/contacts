package com.nown.contacts.repository;

import com.nown.contacts.entity.Dustbin;
import com.nown.contacts.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DustbinDao extends JpaRepository<Dustbin, Integer> {
    Student save(Student student);
}
