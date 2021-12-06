package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.StudentClassInnerJoinDto;
import com.example.edu_institute.Dto.StudentHasClassDto;
import com.example.edu_institute.Entity.ClassEntity;
import com.example.edu_institute.Entity.ClassHasStudentEntity;
import com.example.edu_institute.Entity.StudentClassInnerJoinEntity;
import com.example.edu_institute.Entity.StudentEntity;
import com.example.edu_institute.Repository.ClassRepository;
import com.example.edu_institute.Repository.StudentClassInnerJoinRepository;
import com.example.edu_institute.Repository.StudentHasClassRepository;
import com.example.edu_institute.Repository.StudentRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.StudentHasClassService;
import com.example.edu_institute.Utill.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentHasClassServiceImplement implements StudentHasClassService {
    @Autowired
    StudentHasClassRepository studentHasClassRepository;
    @Autowired
    ClassRepository classRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentClassInnerJoinRepository studentClassInnerJoinRepository;


    @Override
    public ResponseEntity<Object> GetMyClass(StudentClassInnerJoinDto studentClassInnerJoinDto) {

        try {
            List<StudentClassInnerJoinEntity> studentClassInnerJoinEntities = studentClassInnerJoinRepository.GetAllDataByStudentId(studentClassInnerJoinDto.getStudentId(),studentClassInnerJoinDto.getMonth(),studentClassInnerJoinDto.getYear());

            return ResponseHandler.generateResponse(HttpStatus.OK, studentClassInnerJoinEntities, Constants.SUCCESS);

        } catch (Exception Ex) {

            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
        }


    }

    @Override
    public ResponseEntity<Object> EnrollStudentsForClass(StudentHasClassDto studentHasClassDto) {

        try {
            StudentHasClassDto studentHasClassDto1 = new StudentHasClassDto();

            List<StudentEntity> studentEntities = studentRepository.SearchStudentByClassId(studentHasClassDto.getClassId());

            for (StudentEntity studentEntity : studentEntities) {

                ClassHasStudentEntity MyClass = new ClassHasStudentEntity();
                MyClass.setStudentId(studentEntity.getStudentId());
                MyClass.setClassId(studentEntity.getClassId());
                MyClass.setClassId(studentEntity.getClassId());
                MyClass.setUniqueClassId(studentHasClassDto.getUniqueClassId());
                MyClass.setPaidStatus("0");
                studentHasClassRepository.save(MyClass);
            }

            ClassEntity classEntity = classRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
            classEntity.setTotalStudents(studentEntities.size());

            classRepository.save(classEntity);

            return ResponseHandler.generateResponse(HttpStatus.OK, studentHasClassDto1, Constants.SUCCESS);

        } catch (Exception Ex) {

            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

        }
    }

    @Override
    public ResponseEntity<Object> CustomEnrollStudentsForClass(StudentHasClassDto studentHasClassDto) {

        try {
            StudentEntity studentEntity = studentRepository.SearchByStudentId(studentHasClassDto.getStudentId());

            if(studentEntity == null){

                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

            }else{
                ClassHasStudentEntity classHasStudentEntity1 = studentHasClassRepository.CheckStudentExist(studentHasClassDto.getStudentId(),studentHasClassDto.getUniqueClassId());

                if(classHasStudentEntity1 == null){
                    ClassHasStudentEntity classHasStudentEntity = new ClassHasStudentEntity();

                    classHasStudentEntity.setStudentId(studentEntity.getStudentId());
                    classHasStudentEntity.setUniqueClassId(studentHasClassDto.getUniqueClassId());
                    classHasStudentEntity.setClassId(studentHasClassDto.getClassId());
                    classHasStudentEntity.setPaidStatus("0");

                    studentHasClassRepository.save(classHasStudentEntity);

                    List<ClassHasStudentEntity> classHasStudentEntities = studentHasClassRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
                    ClassEntity classEntity = classRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
                    classEntity.setTotalStudents(classHasStudentEntities.size());

                    classRepository.save(classEntity);
                }else{

                    return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.CONFLICT);
                }


            }

            return ResponseHandler.generateResponse(HttpStatus.OK,  Constants.SUCCESS);

        } catch (Exception Ex) {

            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

        }


    }

    @Override
    public ResponseEntity<Object> DeleteClass(StudentHasClassDto studentHasClassDto) throws NullPointerException {

        try {
            ClassEntity classEntity = classRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
            List<ClassHasStudentEntity> classHasStudentEntity = studentHasClassRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());
            studentHasClassRepository.deleteAll(classHasStudentEntity);
            classRepository.delete(classEntity);
        } catch (Exception Ex) {
            Ex.printStackTrace();
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK, Constants.SUCCESS);
    }

    @Override
    public ResponseEntity<Object> SetPaymentStatus(StudentHasClassDto studentHasClassDto) throws NullPointerException {

        String PaymentStatus= "";
        try {
            ClassHasStudentEntity classHasStudentEntity1 = studentHasClassRepository.CheckStudentExist(studentHasClassDto.getStudentId(),studentHasClassDto.getUniqueClassId());

            if(classHasStudentEntity1 != null){
                if(classHasStudentEntity1.getPaidStatus().equals("1")){
                    classHasStudentEntity1.setPaidStatus("0");
                    PaymentStatus = "0";
                }else{
                    classHasStudentEntity1.setPaidStatus("1");
                    PaymentStatus = "1";
                }
               studentHasClassRepository.save(classHasStudentEntity1);
            }
        } catch (Exception Ex) {
            Ex.printStackTrace();
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS,  Constants.FAILURE);
        }
        return ResponseHandler.generateResponse(HttpStatus.OK,PaymentStatus, Constants.SUCCESS);
    }

    @Override
    public ResponseEntity<Object> CheckAccess(StudentHasClassDto studentHasClassDto) {

        try {
            String Status = null;
            ClassHasStudentEntity classHasStudentEntity = studentHasClassRepository.SelectAccess(studentHasClassDto.getUniqueClassId(), studentHasClassDto.getStudentId());

            ClassEntity classEntity = classRepository.SearchByUniqueClassId(studentHasClassDto.getUniqueClassId());

            if (classHasStudentEntity.getPaidStatus().equals("1") || classEntity.getAccess().equals("1")) {
                Status = Constants.SUCCESS;
            }
            if (classHasStudentEntity.getPaidStatus().equals("1")) {
                Status = Constants.SUCCESS;
            }
            if (classHasStudentEntity.getPaidStatus().equals("0") && classEntity.getAccess().equals("0")) {
                Status = Constants.FAILURE;
            }

            return ResponseHandler.generateResponse(HttpStatus.OK, null, Status);
        } catch (Exception Ex) {

            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
        }


    }


}
