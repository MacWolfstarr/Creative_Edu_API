package com.example.edu_institute.Dto;

import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.ClassHasStudentEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentHasClassDto {

//    private ClassEntity classEntity;
    //private List<ClassHasStudentEntity> classHasStudentEntity;
   // private List<ClassEntity> classEntities;
    private Long id;

    private String teacherId;

    private String studentId;

    private String classId;

    private String uniqueClassId;

    private String className;

    private String paidStatus;

    private String year;


    private String month;


    private String day;


    private String timeFrom;


    private String timeTo;


    private String zoomLink;


    private String access;


    private String institute;


}
