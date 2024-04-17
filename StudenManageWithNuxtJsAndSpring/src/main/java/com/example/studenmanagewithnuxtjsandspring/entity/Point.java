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
@Table(name = "point")
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "diligence_point")
    private float diligencePoint;

    @Column(name = "mid_term_point")
    private float midTermPoint;

    @Column(name = "final_point")
    private float finalPoint;

    private Boolean status;

    private float gpa;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
}
