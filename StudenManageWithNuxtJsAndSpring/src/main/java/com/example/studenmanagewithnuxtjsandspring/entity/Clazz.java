package com.example.studenmanagewithnuxtjsandspring.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "clazz")
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "class_name")
    private String className;

    @Column(name = "course_num")
    private Integer courseNum;

    @Column(name = "advisor_name")
    private String advisorName;

    @Column(name = "monitor_name")
    private String monitorName;


}
