package com.nown.contacts.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Student.class)
public class Student_ {

    public static volatile SingularAttribute<Student, Integer> id;// 用户ID，自增量
    public static volatile SingularAttribute<Student, String> number;
    public static volatile SingularAttribute<Student, String> name;
    public static volatile SingularAttribute<Student, String> sex;
    public static volatile SingularAttribute<Student, Integer> age;
    public static volatile SingularAttribute<Student, String> birthday;
    public static volatile SingularAttribute<Student, String> tel;
    public static volatile SingularAttribute<Student, String> address;
    public static volatile SingularAttribute<Student, String> mail;
    public static volatile SingularAttribute<Student, String> major;

}
