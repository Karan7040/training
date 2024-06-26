package com.colruyt.productmanagementsvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
       @ExceptionHandler(ProductNotFoundException.class)
        public ProblemDetail handler()
        {
            return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,"Product Not found");
        }
    }


