package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "cuties")
@Data
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    @NotBlank
    private String name;

    @ManyToOne
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @Min(0)
    private double area;

    @Min(0)
    private long population;

    @Min(0)
    private double gdp;

    @Column(columnDefinition = "text")
    private String description;

}
