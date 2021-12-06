package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.StudentDto;
import com.example.edu_institute.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Student")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping(value = "/AddStudent")
    HttpEntity<Object> AddStudent(@RequestBody StudentDto studentDto) {
        return studentService.AddStudent(studentDto);
    }


    @PostMapping(value = "/GetStudentInfo")
    HttpEntity<Object> GetStudentInfo(@RequestBody StudentDto studentDto) {
        return studentService.GetStudentInfo(studentDto);
    }


    @PostMapping(value = "/UpdateStudentInfo")
    HttpEntity<Object> UpdateStudentInfo(@RequestBody StudentDto studentDto) {
        return studentService.UpdateStudentInfo(studentDto);
    }

    @PostMapping(value = "/SetPassword")
    HttpEntity<Object> SetPassword(@RequestBody StudentDto studentDto) {
        return studentService.SetPassword(studentDto);
    }

    @PostMapping(value = "/DeleteStudent")
    HttpEntity<Object> DeleteStudent(@RequestBody StudentDto studentDto) {
        return studentService.DeleteStudent(studentDto);
    }

    @PostMapping(value = "/BlockStudent")
    HttpEntity<Object> BlockStudent(@RequestBody StudentDto studentDto) {
        return studentService.BlockStudent(studentDto);
    }

    @PostMapping(value = "/ApproveRequest")
    HttpEntity<Object> ApproveRequest(@RequestBody StudentDto studentDto) {
        return studentService.ApproveRequest(studentDto);
    }
}
