package com.example.paymentservice.web.controller.advice;

import com.example.paymentservice.web.controller.exception.BindingException;
import com.example.paymentservice.web.dto.ErrorResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ErrorsAdvice {

    @ExceptionHandler({
            BindingException.class,
            HttpMessageNotReadableException.class,
            DataIntegrityViolationException.class,
            MethodArgumentTypeMismatchException.class,
            NoResourceFoundException.class
    })
    private ResponseEntity<ErrorResponseDto> handleException(Exception e) {
        ErrorResponseDto response = new ErrorResponseDto("Bad Request", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalStateException.class)
    private ResponseEntity<ErrorResponseDto> handleException(IllegalStateException e) {
        ErrorResponseDto response = new ErrorResponseDto("Internal Server", e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
