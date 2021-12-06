package com.example.edu_institute.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class StudentClassInnerJoinDto {

    private String id;


    private String teacherId;


    private String classId;


    private String uniqueClassId;


    private  String className;


    private String year;


    private String month;


    private String day;


    private String timeFrom;


    private String timeTo;


    private String zoomLink;


    private String access;


    private String institute;


    private String studentId;


    private String paidStatus;
}
