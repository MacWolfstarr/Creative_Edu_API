package com.example.edu_institute.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="meeting_records")
public class RecordsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "TeacherId")
    private String teacherId;

    @Column(name = "ClassId")
    private String classId;

    @Column(name = "UniqueClassId")
    private String uniqueClassId;

    @Column(name = "ClassName")
    private  String className;

    @Column(name = "Date")
    private String date;

    @Column(name = "TimeFrom")
    private String timeFrom;

    @Column(name = "TimeTo")
    private String timeTo;

    @Column(name = "RecordLink")
    private Integer recordLink;

    @Column(name = "Remarks")
    private Integer remarks;
}
