package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.InstituteDto;
import org.springframework.http.ResponseEntity;

public interface InstituteService {


    ResponseEntity<Object> GetAllInstitute(InstituteDto instituteDto);
}
