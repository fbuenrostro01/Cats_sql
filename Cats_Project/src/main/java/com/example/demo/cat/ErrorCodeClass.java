package com.example.demo.cat; // use your project's package name

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
//this is so i can used it to get the proper eorry codes in postman
//cocers ALL the classes sinces igs gloval
//the default one woult not hsow the proper erors in pasman
//unsure why gave up fo rnow

//this bad boid right here iwats what tells spring it should hangle all eorros globally
@ControllerAdvice


public class ErrorCodeClass {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}