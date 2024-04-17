package com.example.studenmanagewithnuxtjsandspring.model.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertLecturerRequest {
    private String fullName;
    private String email;
    private String phone;
    private Integer genderId;
    private List<Integer> subjectIds;
}
