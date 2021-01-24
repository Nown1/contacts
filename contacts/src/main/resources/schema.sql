drop table if exists admin;
create table admin(
    id int(10) NOT NULL AUTO_INCREMENT,
    name varchar(20) DEFAULT NULL,
    password varchar(20) DEFAULT NULL,
    primary key (id)
)engine =InnoDB;

drop table if exists student;
create table student(
    id int(10) NOT NULL AUTO_INCREMENT,
    number varchar(10) DEFAULT NULL,
    name varchar(20) DEFAULT NULL,
    sex varchar(4) DEFAULT NULL,
    age int(10) DEFAULT NULL ,
    birthday varchar(20) DEFAULT NULL,
    tel varchar(20) DEFAULT NULL,
    address varchar(100) DEFAULT NULL,
    mail varchar(40) DEFAULT NULL,
    major varchar(40) DEFAULT NULL,
    primary key (id)
)engine =InnoDB;

drop table if exists dustbin;
create table dustbin(
                        id int(10) NOT NULL AUTO_INCREMENT,
                        stuid int(10) DEFAULT NULL,
                        number varchar(10) DEFAULT NULL,
                        name varchar(20) DEFAULT NULL,
                        sex varchar(4) DEFAULT NULL,
                        age int(10) DEFAULT NULL ,
                        birthday varchar(20) DEFAULT NULL,
                        tel varchar(20) DEFAULT NULL,
                        address varchar(100) DEFAULT NULL,
                        mail varchar(40) DEFAULT NULL,
                        major varchar(40) DEFAULT NULL,
                        primary key (id)
)engine =InnoDB;

drop table if exists major;
create table major(
                      id int(10) NOT NULL  AUTO_INCREMENT,
                      name varchar(20) DEFAULT NULL,
                      primary key (id)
)engine =InnoDB;