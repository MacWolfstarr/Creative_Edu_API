package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="class_has_student")
public class ClassHasStudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "StudentId")
    private String studentId;

    @Column(name = "ClassId")
    private  String classId;

    @Column(name = "PaidStatus")
    private String paidStatus;

    @Column(name = "UniqueClassId")
    private String uniqueClassId;
}
