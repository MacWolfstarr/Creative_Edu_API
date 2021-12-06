package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.CourseDto;
import org.springframework.http.ResponseEntity;


public interface CourseService {

    ResponseEntity<Object> GetAllCourses(CourseDto courseDto);

}
