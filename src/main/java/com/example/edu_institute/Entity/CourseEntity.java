package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="teacher_has_class")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TeacherId")
    private String teacherId;

    @Column(name = "ClassId")
    private String classId;

    @Column(name = "ClassName")
    private  String className;

    @Column(name = "InstituteId")
    private  String instituteId;

}
