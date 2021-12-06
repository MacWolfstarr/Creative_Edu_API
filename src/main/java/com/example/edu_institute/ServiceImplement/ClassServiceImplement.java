package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.ClassDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Repository.ClassRepository;
import com.example.edu_institute.Repository.StudentHasClassRepository;
import com.example.edu_institute.Repository.StudentRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.ClassService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassServiceImplement implements ClassService {

    @Autowired
    ClassRepository classRepository;
    StudentHasClassRepository studentHasClassRepository;
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> GetClassInfo(ClassDto classDto) {


        ClassEntity classEntity = classRepository.SearchByClassId(classDto.getClassId(), classDto.getTeacherId());

        if (classEntity != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, classEntity, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> SetClassInfo(ClassDto classDto) {

        ClassEntity classEntityCheck = classRepository.SearchByUniqueClassId(classDto.getUniqueClassId());
        try {

            if (classEntityCheck == null) {
                ClassEntity classEntity = new ClassEntity();
                classEntity.setClassId(classDto.getClassId());
                classEntity.setUniqueClassId(classDto.getUniqueClassId());
                classEntity.setClassName(classDto.getClassName());
                classEntity.setInstitute(classDto.getInstitute());
                classEntity.setTeacherId(classDto.getTeacherId());
                classEntity.setYear(classDto.getYear());
                classEntity.setMonth(classDto.getMonth());
                classEntity.setDay(classDto.getDay());
                classEntity.setTimeTo(classDto.getTimeTo());
                classEntity.setTimeFrom(classDto.getTimeFrom());
                classEntity.setZoomLink(classDto.getZoomLink());
                classEntity.setAccess(classDto.getAccess());
                classRepository.save(classEntity);

            } else {
                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
            }

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);

        } catch (Exception Ex) {

            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
        }


    }

    @Override
    public ResponseEntity<Object> UpdateClassInfo(ClassDto classDto) {


        ClassEntity classEntity = classRepository.SearchByClassId(classDto.getUniqueClassId(), classDto.getTeacherId());

        if (classEntity != null) {

            classEntity.setClassName(classDto.getClassName());
            classEntity.setTimeTo(classDto.getTimeTo());
            classEntity.setTimeFrom(classDto.getTimeFrom());
            classEntity.setZoomLink(classDto.getZoomLink());
//            classEntity.setRecords(classDto.getRecords());

            classRepository.save(classEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> GetAllClassInfo(ClassDto classDto) throws NullPointerException {

        List<ClassEntity> AllClasses = classRepository.SearchByTeacherId(classDto.getTeacherId());

        if (AllClasses != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, AllClasses, Constants.SUCCESS);

        }
        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> SetAccess(ClassDto classDto) {


        ClassEntity classEntity = classRepository.SearchByClassId(classDto.getUniqueClassId(), classDto.getTeacherId());

        if (classEntity != null) {

            classEntity.setAccess(classDto.getAccess());
            classRepository.save(classEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }

    @Override
    public ResponseEntity<Object> GetTodayClass(ClassDto classDto) throws NullPointerException {

        List<ClassEntity> AllClasses = classRepository.SearchTodayClass(classDto.getTeacherId(), classDto.getYear(), classDto.getMonth(), classDto.getDay());

        if (AllClasses != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, AllClasses, Constants.SUCCESS);
        }
        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }

}


