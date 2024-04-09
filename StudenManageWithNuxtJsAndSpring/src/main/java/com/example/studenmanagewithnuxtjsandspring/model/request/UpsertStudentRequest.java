package com.example.studenmanagewithnuxtjsandspring.model.request;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertStudentRequest {
    private String fullName;
    private Date birthDate;
    private String address;
    private Date admissionDate;
    private Date graduationDate;
    private String gender;
    private String email;
    private String phone;
    private String ethnicity;
    private float gpa;
    private String status;
    private Integer majorId;
    private Integer clazzId;
}
