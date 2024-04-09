package com.example.studenmanagewithnuxtjsandspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "birth_date")
    private Date birthDate;
    private String address;
    @Column(name = "admission_date")
    private Date admissionDate;
    @Column(name = "graduation_date")
    private Date graduationDate;
    private String gender;
    private String email;
    private String phone;
    private String ethnicity;
    private float gpa;
    private String status;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @ManyToOne
    @JoinColumn(name = "clazz_id")
    private Clazz clazz;
}
