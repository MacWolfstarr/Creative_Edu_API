package com.example.edu_institute.ServiceImplement;

import com.example.edu_institute.Dto.AuthenticationDto;
import com.example.edu_institute.Dto.UserDto;
import com.example.edu_institute.Entity.AuthenticationEntity;
import com.example.edu_institute.Entity.StudentEntity;
import com.example.edu_institute.Entity.TeacherEntity;
import com.example.edu_institute.Repository.AuthenticationRepository;
import com.example.edu_institute.Repository.StudentRepository;
import com.example.edu_institute.RepositoryHandler.ResponseHandler;
import com.example.edu_institute.Service.LoginService;
import com.example.edu_institute.Utill.Constants;
import com.example.edu_institute.Utill.GUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class LoginServiceImplementation implements LoginService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AuthenticationRepository authenticationRepository;

    @Override
    public ResponseEntity<Object> UserLogin(UserDto userDto) {

        try {
            if (userDto.getUserId() != null && userDto.getPassword() != null && !userDto.getUserId().isBlank() && !userDto.getPassword().isBlank()) {

                if (userDto.getUserId().startsWith("TREDU")) {
                    StudentEntity studentEntity = studentRepository.LoginStudent(userDto.getUserId(), userDto.getPassword());
                    if (studentEntity.getStudentId().equals(userDto.getUserId()) && studentEntity.getPassword().equals(userDto.getPassword())) {
                        String LoginGUID = GUID.GenerateGUID(userDto.getUserId());
                        AuthenticationEntity authenticationEntity = new AuthenticationEntity();
                        authenticationEntity.setGuid(LoginGUID);
                        authenticationEntity.setUserAgent(userDto.getUserAgent());
                        authenticationEntity.setStatus("0");
                        Date date = new Date();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        authenticationEntity.setDateTime(formatter.format(date));
                        authenticationRepository.save(authenticationEntity);
                        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, studentEntity, Constants.SUCCESS, LoginGUID);

                    } else {
                        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
                    }

                } else if (userDto.getUserId().startsWith("TEC")) {

                }
            } else {
                return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
            }
        } catch (Exception Ex) {
            return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);
        }

        return ResponseHandler.generateResponse(HttpStatus.MULTI_STATUS, null, Constants.FAILURE);

    }
}
