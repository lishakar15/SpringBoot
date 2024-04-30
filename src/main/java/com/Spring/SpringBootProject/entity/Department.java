package com.Spring.SpringBootProject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name ="department_detail")
public class Department {

    @Id
    @SequenceGenerator(
            name = "dept_seq",
            sequenceName = "dept_seq",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="dept_seq")
    private Long departmentId;
    private String departmentName;
    private String departmentCode;

}
