package com.example.edu_institute.Controller;

import com.example.edu_institute.Dto.UserDto;
import com.example.edu_institute.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping(value = "/Login")
@CrossOrigin(origins = "*")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping(value = "/UserLogin")
    HttpEntity<Object> GetTodayClass(@RequestBody UserDto userDto) throws UnsupportedEncodingException {
        return loginService.UserLogin(userDto);
    }

}
