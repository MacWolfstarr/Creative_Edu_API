package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="student")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "StudentId")
    private String studentId;

    @Column(name = "FirstName")
    private  String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Age")
    private String age;

    @Column(name = "Grade")
    private String grade;

    @Column(name = "Address")
    private String address;

    @Column(name = "ClassId")
    private String classId;

    @Column(name = "School")
    private String school;

    @Column(name = "Guardian")
    private String guardian;

    @Column(name = "Contact")
    private String contact;

    @Column(name = "Institute")
    private String institute;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "DateOfBirth")
    private String dateOfBirth;


    @Column(name = "DateTime")
    private String dateTime;

    @Column(name = "Password")
    private String password;

    @Column(name = "BlockStatus")
    private String blockStatus;
}
