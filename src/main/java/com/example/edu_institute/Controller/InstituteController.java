package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.InstituteDto;
import com.example.edu_institute.Service.InstituteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="/Institute")
@CrossOrigin(origins = "*")
public class InstituteController {


    @Autowired
    InstituteService instituteService;

    @PostMapping(value = "/GetAllInstitute")
    HttpEntity<Object> AllInstituteInfo(@RequestBody InstituteDto instituteDto) {
        return instituteService.GetAllInstitute(instituteDto);
    }
}
