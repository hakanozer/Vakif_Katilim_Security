package com.works.configs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handler( MethodArgumentNotValidException exception ) {

        List<Map> lshm = new ArrayList<>();
        List<FieldError> fieldErrors = exception.getFieldErrors();
        for ( FieldError error : fieldErrors ) {
            Map<String, String > hm = new HashMap<>();
            String filed = error.getField();
            String message = error.getDefaultMessage();
            hm.put("filed", filed );
            hm.put("message", message);
            lshm.add(hm);
        }

        return new ResponseEntity(lshm, HttpStatus.BAD_REQUEST);
    }

}
