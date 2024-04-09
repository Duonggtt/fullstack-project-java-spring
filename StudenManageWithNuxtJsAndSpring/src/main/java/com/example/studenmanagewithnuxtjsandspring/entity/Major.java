package com.example.studenmanagewithnuxtjsandspring.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Table(name = "major")
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "major_name")
    private String majorName;

    @Column(name = "detail")
    private String detail;

    @Column(name = "year_quantity")
    private Integer yearQuantity;
}
