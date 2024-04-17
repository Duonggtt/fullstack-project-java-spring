package com.example.studenmanagewithnuxtjsandspring.model.request;

import com.example.studenmanagewithnuxtjsandspring.entity.Student;
import com.example.studenmanagewithnuxtjsandspring.entity.Subject;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UpsertPointRequest {
    private float diligencePoint;
    private float midTermPoint;
    private float finalPoint;
    private Boolean status;
    private Integer studentId;
    private Integer subjectId;
}
