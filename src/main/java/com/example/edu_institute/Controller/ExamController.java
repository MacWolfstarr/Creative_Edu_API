package com.example.edu_institute.Controller;


import com.example.edu_institute.Dto.ClassDto;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Class")
@CrossOrigin(origins = "*")
public class ExamController {


    @PostMapping(value = "/SaveResult")
    HttpEntity<Object> ClassInfo(@RequestBody ClassDto classDto) {
        return classService.GetClassInfo(classDto);
    }
}
