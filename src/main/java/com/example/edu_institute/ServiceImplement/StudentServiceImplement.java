package com.example.edu_institute.ServiceImplement;


import com.example.edu_institute.Dto.StudentDto;

import com.example.edu_institute.Entity.StudentEntity;

import com.example.edu_institute.Repository.StudentRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.StudentService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class StudentServiceImplement implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<Object> AddStudent(StudentDto studentDto) {
        StudentEntity CheckStudentIdExist;
        String StudentId;
        StudentEntity CheckStudentExist = studentRepository.CheckStudentExist(studentDto.getFirstName(), studentDto.getLastName(), studentDto.getContact());

        if (CheckStudentExist == null) {

            do {
                Random random = new Random();
                String RandomNumber = Integer.toString(random.nextInt(900) + 100);
                System.out.println(RandomNumber);
                StudentId = "TREDU" + RandomNumber;
                CheckStudentIdExist = studentRepository.SearchByStudentId(StudentId);

            } while (CheckStudentIdExist != null);


            try {
                StudentEntity studentEntity = new StudentEntity();
                studentEntity.setStudentId(StudentId);
                studentEntity.setFirstName(studentDto.getFirstName());
                studentEntity.setLastName(studentDto.getLastName());
                studentEntity.setAge(studentDto.getAge());
                studentEntity.setDateOfBirth(studentDto.getDateOfBirth());
                studentEntity.setGrade(studentDto.getGrade());
                studentEntity.setAddress(studentDto.getAddress());
                studentEntity.setSchool(studentDto.getSchool());
                studentEntity.setInstitute(studentDto.getInstitute());
                studentEntity.setClassId(studentDto.getClassId());
                studentEntity.setGender(studentDto.getGender());
                studentEntity.setGuardian(studentDto.getGuardian());
                studentEntity.setContact(studentDto.getContact());
                studentEntity.setBlockStatus("2");
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                studentEntity.setDateTime(formatter.format(date));
                studentEntity.setPassword(studentDto.getPassword());
                studentRepository.save(studentEntity);

            } catch (Exception Ex) {
                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.FAILURE);
            }
        } else {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, Constants.CONFLICT);
        }

        return ResponseHandler.generateResponse(HttpStatus.OK, StudentId, Constants.SUCCESS);
    }


    @Override
    public ResponseEntity<Object> GetStudentInfo(StudentDto studentDto) {


        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {

            return ResponseHandler.generateResponse(HttpStatus.OK, studentEntity, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> UpdateStudentInfo(StudentDto studentDto) {


        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {
            studentEntity.setFirstName(studentDto.getFirstName());
            studentEntity.setLastName(studentDto.getLastName());
            studentEntity.setAge(studentDto.getAge());
            studentEntity.setGrade(studentDto.getGrade());
            studentEntity.setAddress(studentDto.getAddress());
            studentEntity.setGender(studentDto.getGender());
            studentEntity.setSchool(studentDto.getSchool());
            studentEntity.setGuardian(studentDto.getGuardian());
            studentEntity.setContact(studentDto.getContact());
            studentEntity.setClassId(studentDto.getClassId());
            studentEntity.setInstitute(studentDto.getInstitute());
            studentRepository.save(studentEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> SetPassword(StudentDto studentDto) {


        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {

            studentEntity.setPassword(studentDto.getPassword());
            studentRepository.save(studentEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }


    @Override
    public ResponseEntity<Object> DeleteStudent(StudentDto studentDto) {


        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {

            studentRepository.delete(studentEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }

    @Override
    public ResponseEntity<Object> BlockStudent(StudentDto studentDto) {

        String BlockStatus ;
        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {
            if (studentEntity.getBlockStatus().equals("1")) {
                studentEntity.setBlockStatus("0");
                BlockStatus = "0";
            } else {
                studentEntity.setBlockStatus("1");
                BlockStatus = "1";
            }
            studentRepository.save(studentEntity);
            return ResponseHandler.generateResponse(HttpStatus.OK, BlockStatus, Constants.SUCCESS);

        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }

    @Override
    public ResponseEntity<Object> ApproveRequest(StudentDto studentDto) {

        String RequestStatus ;
        StudentEntity studentEntity = studentRepository.SearchByStudentId(studentDto.getStudentId());

        if (studentEntity != null) {
            if (studentEntity.getBlockStatus().equals("2")) {
                studentEntity.setBlockStatus("0");
                RequestStatus = "Success";
            } else {
                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
            }
            studentRepository.save(studentEntity);
            return ResponseHandler.generateResponse(HttpStatus.OK, RequestStatus, Constants.SUCCESS);

        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
    }
}
