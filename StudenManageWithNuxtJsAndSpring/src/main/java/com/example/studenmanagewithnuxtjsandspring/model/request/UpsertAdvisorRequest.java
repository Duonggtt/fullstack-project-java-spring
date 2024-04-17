package com.example.studenmanagewithnuxtjsandspring.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertAdvisorRequest {
    private String name;
    private String email;
    private String phone;
    private Integer genderId;
}
