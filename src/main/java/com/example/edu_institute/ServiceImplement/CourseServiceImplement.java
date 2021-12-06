package com.example.edu_institute.ServiceImplement;


import com.example.edu_institute.Dto.CourseDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.CourseEntity;
import com.example.edu_institute.Repository.CourseRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.CourseService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImplement implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public ResponseEntity<Object> GetAllCourses(CourseDto courseDto) {

        List<CourseEntity> AllCourses = courseRepository.SearchCoursesByTeacherId(courseDto.getTeacherId(), courseDto.getInstituteId());

        if(AllCourses != null){
            return ResponseHandler.generateResponse(HttpStatus.OK, AllCourses, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

    }
}
