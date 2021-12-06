package com.example.edu_institute.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="authentication")
public class AuthenticationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "GUID")
    private String guid;

    @Column(name = "UserAgent")
    private String userAgent;

    @Column(name = "Status")
    private String status;

    @Column(name = "DateTime")
    private  String dateTime;
}
