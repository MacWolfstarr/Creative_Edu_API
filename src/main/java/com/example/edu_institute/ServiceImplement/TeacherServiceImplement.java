package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Dto.TeacherDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.TeacherEntity;
import com.example.edu_institute.Repository.TeacherRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.TeacherService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImplement implements TeacherService {
    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public ResponseEntity<Object> AddTeacher(TeacherDto teacherDto) {

        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setTeacherId(teacherDto.getTeacherId());
        teacherEntity.setFirstName(teacherDto.getFirstName());
        teacherEntity.setLastName(teacherDto.getLastName());
        teacherEntity.setMobileNumber(teacherDto.getMobileNumber());
        teacherEntity.setUserName(teacherDto.getUserName());
        teacherEntity.setPassword(teacherDto.getPassword());

        teacherRepository.save(teacherEntity);

        if (teacherEntity != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> GetTeacherInfo(TeacherDto teacherDto) {


        TeacherEntity teacherEntity = teacherRepository.SearchByTeacherId(teacherDto.getTeacherId());

        if (teacherEntity != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, teacherEntity, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> UpdateTeacherInfo(TeacherDto teacherDto) {


        TeacherEntity teacherEntity = teacherRepository.SearchByTeacherId(teacherDto.getTeacherId());

        if (teacherEntity != null) {

            teacherEntity.setFirstName(teacherDto.getFirstName());
            teacherEntity.setLastName(teacherDto.getLastName());
            teacherEntity.setMobileNumber(teacherDto.getMobileNumber());

            teacherRepository.save(teacherEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


}
