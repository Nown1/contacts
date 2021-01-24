package com.nown.contacts.repository;

import com.nown.contacts.entity.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MajorDaoTest {

    @Autowired
    MajorDao majorDao;

    @Test
    public void reset(){
        for (int i=1;i<9;i++){
            Major major=new Major();
            major.setName("专业"+i);
            majorDao.save(major);
        }
    }
}