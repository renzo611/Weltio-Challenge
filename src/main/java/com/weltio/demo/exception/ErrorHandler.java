package com.weltio.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(DataAlreadyExistException.class)
    public ResponseEntity<?> handleDataAlreadyExistException(DataAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<String> invalidCredentialsException(InvalidCredentialsException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> notFoundException(NotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
