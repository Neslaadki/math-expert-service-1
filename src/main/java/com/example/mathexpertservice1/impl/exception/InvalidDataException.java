package com.example.mathexpertservice1.impl.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid data format")
public class InvalidDataException extends RuntimeException {

}
