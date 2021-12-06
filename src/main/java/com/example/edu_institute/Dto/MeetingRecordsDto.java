package com.example.edu_institute.Dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MeetingRecordsDto {


    private Long id;


    private String teacherId;


    private String uniqueClassId;


    private  String className;


    private String classId;


    private String institute;


    private String date;


    private String timeFrom;


    private String timeTo;


    private String recordLink;


    private String remarks;
}
