package com.example.studenmanagewithnuxtjsandspring.model.request;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertClazzRequest {
    private String className;
    private Integer courseId;
    private Integer academicYearId;
    private List<Integer> advisorIds;
}
