package com.example.A00444846_MCDA5550.ResponseType;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ErrorResponse {

    public static ResponseEntity errorResponseEntity(HttpStatus httpStatus, String msg){
        Map<String, String> responseMap = new HashMap<>() {{
            put("Error", msg);
        }};
        return ResponseEntity.status(httpStatus).body(responseMap);
    }

    public static ResponseEntity successResponseEntity(Map<String, String> map){
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }
}
