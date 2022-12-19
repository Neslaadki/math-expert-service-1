package com.example.mathexpertservice1.impl.handler;

import com.example.mathexpertservice1.impl.exception.InvalidDataException;
import com.example.mathexpertservice1.impl.exception.NoSuchUserFound;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidDataException.class)
    protected ResponseEntity<AwesomeException> handleInvalidDataException() {
        return new ResponseEntity<>(new AwesomeException("Invalid data of file"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchUserFound.class)
    protected ResponseEntity<AwesomeException> handleThereIsNoSuchUserFound() {
        return new ResponseEntity<>(new AwesomeException("Can't find user with included id"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class AwesomeException {
        private String message;
    }
}