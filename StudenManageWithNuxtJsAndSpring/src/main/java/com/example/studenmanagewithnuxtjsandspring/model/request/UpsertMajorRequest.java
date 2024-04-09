package com.example.studenmanagewithnuxtjsandspring.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertMajorRequest {
    private String majorName;
    private String detail;
    private Integer yearQuantity;
}
