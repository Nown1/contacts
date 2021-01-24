package com.nown.contacts.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ExcelProperty(value = "序号",index = 0)
    private Integer id;

    @ExcelProperty(value = "学号",index = 1)
    private String number;
    @ExcelProperty(value = "姓名",index = 2)
    private String name;
    @ExcelProperty(value = "性别",index = 3)
    private String sex;
    @ExcelProperty(value = "年龄",index = 4)
    private Integer age;
    @ExcelProperty(value = "出生日期",index = 5)
    private String birthday;
    @ExcelProperty(value = "手机号码",index = 6)
    private String tel;
    @ExcelProperty(value = "家庭住址",index = 7)
    private String address;
    @ExcelProperty(value = "电子邮箱",index = 8)
    private String mail;
    @ExcelProperty(value = "专业",index = 9)
    private String major;
}
