package com.nown.contacts.controller;

import com.nown.contacts.entity.Major;
import com.nown.contacts.repository.MajorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/major")
public class MajorController {

    @Autowired
    private MajorDao majorDao;

    @GetMapping("/findAll")
    public List<Major> findAll(){
        return majorDao.findAll();
    }

}
