package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "nations")
@Data
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
}
