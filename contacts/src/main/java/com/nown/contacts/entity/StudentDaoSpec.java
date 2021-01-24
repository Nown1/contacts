package com.nown.contacts.entity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StudentDaoSpec {
    public static Specification<Student> getSpec(
            final String number,
            final String name,
            final String sex,
            final Integer age,
            final String birthday,
            final String tel,
            final String address,
            final String mail,
            final String major) {

        return new Specification<Student>() {

            @SuppressWarnings("unused")
            @Override
            public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = null;
                if (number!=null){
                    System.out.println("正在操作number！！！");
                    Predicate p2 = cb.equal(root.get(Student_.number), number);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (name!=null) {
                    System.out.println("正在操作name！！！");
                    Predicate p2 = cb.equal(root.get(Student_.name), name);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (sex!=null){
                    System.out.println("正在操作sex！！！");
                    Predicate p2 = cb.equal(root.get(Student_.sex), sex);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (age != null) {
                    System.out.println("正在操作age！！！");
                    Predicate p2 = cb.equal(root.get(Student_.age), age);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (birthday!=null) {
                    System.out.println("正在操作birthday！！！");
                    Predicate p2 = cb.equal(root.get(Student_.birthday), birthday);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (tel!=null) {
                    System.out.println("正在操作tel！！！");
                    Predicate p2 = cb.equal(root.get(Student_.tel), tel);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (address!=null) {
                    System.out.println("正在操作address！！！");
                    Predicate p2 = cb.equal(root.get(Student_.address), address);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (mail!=null) {
                    System.out.println("正在操作mail！！！");
                    Predicate p2 = cb.equal(root.get(Student_.mail), mail);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (major!=null) {
                    System.out.println("正在操作major！！！");
                    Predicate p2 = cb.equal(root.get(Student_.major), major);
                    if (p1 != null) {
                        p1 = cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }

                return p1;
            }
        };
    }

}