package com.example.edu_institute.Utill;

import com.example.edu_institute.Entity.AuthenticationEntity;
import com.example.edu_institute.Repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

@Service
public class GUID {

    @Autowired
    private static AuthenticationRepository authenticationRepository;

    public static String GenerateGUID(String UserRole) {
        String AuthenticateGUID;

        byte[] encodedBytes = Base64.getEncoder().encode(UserRole.getBytes(StandardCharsets.UTF_8));

        UUID GUID = UUID.randomUUID();
        AuthenticateGUID = GUID + "." + new String(encodedBytes);
        return AuthenticateGUID;
    }


    public static boolean CheckGUID(String GUID, String UserRole){

        AuthenticationEntity authenticationEntity = authenticationRepository.SearchByGUID(GUID);

        if(authenticationEntity.getGuid().equals(GUID) && authenticationEntity.getGuid().split("\\.")[1].equals(UserRole) && authenticationEntity.getStatus().equals("0")){

            return true;
        }else{
            return false;
        }
    }
}
