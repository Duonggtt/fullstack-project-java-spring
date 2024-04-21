package com.example.studenmanagewithnuxtjsandspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "grade_scale")
public class GradeScale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "grade", length = 2)
    private String grade;

    @Column(name = "min_gpa")
    private Float minGpa;

    @Column(name = "max_gpa")
    private Float maxGpa;


}
