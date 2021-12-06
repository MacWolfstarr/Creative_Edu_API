package com.example.edu_institute.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassDto {

    private Long id;


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


    private Integer totalStudents;


    private Integer paid;


    private Integer toBePaid;

}
