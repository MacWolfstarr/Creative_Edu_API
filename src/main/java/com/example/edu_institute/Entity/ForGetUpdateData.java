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
public class ForGetUpdateData {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id")
        private Long id;

        @Column(name = "StudentId")
        private String StudentId;

        @Column(name = "UniqueClassId")
        private  String UniqueClassId;

        @Column(name = "slip_name")
        private String slip_name;





}
