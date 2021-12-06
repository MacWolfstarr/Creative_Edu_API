package com.example.edu_institute.RepositoryHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj, String message) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Status", status.value());
        map.put("Data", responseObj);
        map.put("Message", message);
        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateResponse(HttpStatus status,  String message) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Status", status.value());
        map.put("Message", message);
        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateResponse(HttpStatus status, Object responseObj, String message, String GUID) {

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Status", status.value());
        map.put("Data", responseObj);
        map.put("GUID", GUID);
        map.put("Message", message);
        return new ResponseEntity<Object>(map, status);
    }
}
