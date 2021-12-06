package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.CourseDto;
import com.example.edu_institute.Dto.InstituteDto;
import com.example.edu_institute.Entity.CourseEntity;
import com.example.edu_institute.Entity.InstituteEntity;
import com.example.edu_institute.Repository.CourseRepository;
import com.example.edu_institute.Repository.InstituteRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.InstituteService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstituteServiceImplement  implements InstituteService {

    @Autowired
    InstituteRepository instituteRepository;

    @Override
    public ResponseEntity<Object> GetAllInstitute(InstituteDto instituteDto) {

        List<InstituteEntity> AllInstitute = instituteRepository.SearchAllInstitute();

        if(AllInstitute != null){
            return ResponseHandler.generateResponse(HttpStatus.OK, AllInstitute, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

    }

}
