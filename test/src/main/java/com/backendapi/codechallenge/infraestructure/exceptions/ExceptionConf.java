package com.backendapi.codechallenge.infraestructure.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExceptionConf {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Response> handle(ConstraintViolationException e){
        Response responseError = new Response();

        e.getConstraintViolations().forEach(
                r-> {
                    Error error = new Error();
                    error.setCode(HttpStatus.BAD_REQUEST.name());
                    error.setMessage(r.getMessage());
                    responseError.addError(error);
                }
        );
        return new ResponseEntity<>(responseError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handle(ResourceNotFoundException e){
        Error error = new Error();
        error.setCode(HttpStatus.NOT_FOUND.name());
        error.setMessage(e.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handle(MethodArgumentNotValidException e){
        Error error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.name());
        error.setMessage(e.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<Error> handle(DuplicateKeyException e){
        Error error = new Error();
        error.setCode(HttpStatus.BAD_REQUEST.name());
        error.setMessage(e.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}