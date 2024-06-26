package com.colruyt.productmanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductExceptionHandler.class)
            public ProblemDetail handler()
    {
        return ProblemDetail.forStatusAndDetail(HttpStatus.OK,"Exception Found");
    }

}
