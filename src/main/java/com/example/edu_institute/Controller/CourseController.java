package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Dto.CourseDto;
import com.example.edu_institute.Service.ClassService;
import com.example.edu_institute.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Course")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping(value = "/GetAllCoursesInfo")
    HttpEntity<Object> AllClassInfo(@RequestBody CourseDto courseDto) {
        return courseService.GetAllCourses(courseDto);
    }
}
