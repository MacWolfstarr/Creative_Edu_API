package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.StudentDto;
import org.springframework.http.ResponseEntity;

public interface StudentService  {


    ResponseEntity<Object> AddStudent(StudentDto studentDto);
    ResponseEntity<Object> UpdateStudentInfo(StudentDto studentDto);
    ResponseEntity<Object> GetStudentInfo(StudentDto studentDto);
    ResponseEntity<Object> SetPassword(StudentDto studentDto);
    ResponseEntity<Object> DeleteStudent(StudentDto studentDto);
    ResponseEntity<Object> BlockStudent(StudentDto studentDto);
    ResponseEntity<Object> ApproveRequest(StudentDto studentDto);


}
