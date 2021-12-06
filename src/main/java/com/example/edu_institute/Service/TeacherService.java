package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Dto.TeacherDto;
import org.springframework.http.ResponseEntity;

public interface TeacherService {

    ResponseEntity<Object> AddTeacher(TeacherDto teacherDto);
    ResponseEntity<Object> GetTeacherInfo(TeacherDto teacherDto);
    ResponseEntity<Object> UpdateTeacherInfo(TeacherDto teacherDto);
}
