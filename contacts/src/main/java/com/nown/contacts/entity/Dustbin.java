package com.nown.contacts.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "dustbin")
@Data
public class Dustbin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer stuid;
    private String number;
    private String name;
    private String sex;
    private Integer age;
    private String birthday;
    private String tel;
    private String address;
    private String mail;
    private String major;
}
