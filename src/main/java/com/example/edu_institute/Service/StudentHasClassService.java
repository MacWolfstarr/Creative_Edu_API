package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.StudentClassInnerJoinDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import org.springframework.http.ResponseEntity;

public interface StudentHasClassService {

    ResponseEntity<Object> GetMyClass(StudentClassInnerJoinDto studentClassInnerJoinDto);
    ResponseEntity<Object> EnrollStudentsForClass(StudentHasClassDto studentHasClassDto);
    ResponseEntity<Object> CustomEnrollStudentsForClass(StudentHasClassDto studentHasClassDto);
    ResponseEntity<Object> DeleteClass(StudentHasClassDto classDto);
    ResponseEntity<Object> SetPaymentStatus(StudentHasClassDto studentHasClassDto);
    ResponseEntity<Object> CheckAccess(StudentHasClassDto studentHasClassDto);
}
