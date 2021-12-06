package com.example.edu_institute.Service;

import com.example.edu_institute.Dto.UserDto;
import org.springframework.http.ResponseEntity;

import java.io.UnsupportedEncodingException;

public interface LoginService {
    ResponseEntity<Object> UserLogin(UserDto userDto) throws UnsupportedEncodingException;
}
