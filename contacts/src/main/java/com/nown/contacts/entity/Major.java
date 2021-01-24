package com.nown.contacts.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "major")
@Data
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}
