package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
public class StudentClassInnerJoinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "TeacherId")
    private String teacherId;

    @Column(name = "ClassId")
    private String classId;

    @Column(name = "UniqueClassId")
    private String uniqueClassId;

    @Column(name = "ClassName")
    private  String className;

    @Column(name = "Year")
    private String year;

    @Column(name = "Month")
    private String month;

    @Column(name = "Day")
    private String day;

    @Column(name = "TimeFrom")
    private String timeFrom;

    @Column(name = "TimeTo")
    private String timeTo;

    @Column(name = "ZoomLink")
    private String zoomLink;

    @Column(name = "Access")
    private String access;

    @Column(name = "Institute")
    private String institute;

    @Column(name = "StudentId")
    private String studentId;

    @Column(name = "PaidStatus")
    private String paidStatus;


}
