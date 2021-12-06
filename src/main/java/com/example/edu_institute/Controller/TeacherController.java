package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Dto.TeacherDto;
import com.example.edu_institute.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Teacher")
@CrossOrigin(origins = "*")
public class TeacherController {

    @Autowired
    TeacherService teacherService;


    @PostMapping(value = "/AddTeacher")
    HttpEntity<Object> AddTeacher(@RequestBody TeacherDto teacherDto) {
        return teacherService.AddTeacher(teacherDto);
    }


    @PostMapping(value = "/GetTeacherInfo")
    HttpEntity<Object> GetTeacherInfo(@RequestBody TeacherDto teacherDto) {
        return teacherService.GetTeacherInfo(teacherDto);
    }

    @PostMapping(value = "/UpdateTeacherInfo")
    HttpEntity<Object> UpdateTeacherInfo(@RequestBody TeacherDto teacherDto) {
        return teacherService.UpdateTeacherInfo(teacherDto);
    }

}




