package com.example.studenmanagewithnuxtjsandspring.model.request;


import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertStudentRequest {
    private String fullName;
    private Date birthDate;
    private String address;
    private String email;
    private String phone;
    private String cmnd;
    private String ethnicity;
    private String status;
    private Integer genderId;
    private Integer majorId;
    private Integer clazzId;
}
