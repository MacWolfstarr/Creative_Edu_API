package com.example.edu_institute.Dto;

import com.example.edu_institute.Entity.ClassEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllClassesDto {


    private ClassEntity classEntity;
    private List<ClassEntity> allClassInfoList;
}
