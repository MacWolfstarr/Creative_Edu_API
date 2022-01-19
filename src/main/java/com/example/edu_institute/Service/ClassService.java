package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.ClassDto;
import org.springframework.http.ResponseEntity;

public interface ClassService {
    ResponseEntity<Object> GetClassInfo(ClassDto classDto);
    ResponseEntity<Object> GetAllClassInfo(ClassDto classDto);
    ResponseEntity<Object> SetClassInfo(ClassDto classDto);
    ResponseEntity<Object> UpdateClassInfo(ClassDto classDto);
    ResponseEntity<Object> SetAccess(ClassDto classDto);
    ResponseEntity<Object> GetTodayClass(ClassDto classDto);

}
