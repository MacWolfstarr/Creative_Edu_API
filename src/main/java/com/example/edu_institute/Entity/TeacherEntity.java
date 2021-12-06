package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TeacherId")
    private String teacherId;

    @Column(name = "FirstName")
    private  String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "MobileNumber")
    private String mobileNumber;

    @Column(name = "UserName")
    private String userName;

    @Column(name = "Password")
    private String password;
}
