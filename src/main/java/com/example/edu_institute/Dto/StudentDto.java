package com.example.edu_institute.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class StudentDto {

    private Long id;



    private String studentId;


    private  String firstName;


    private String lastName;


    private String age;


    private String grade;


    private String address;


    private String classId;


    private String school;


    private String guardian;


    private String contact;


    private String institute;


    private String gender;


    private String dateOfBirth;


    private String dateTime;


    private String password;


    private String blockStatus;
}
