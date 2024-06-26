package com.example.customermanagement.exception;

import com.example.customermanagement.model.enums.ErrorMessage;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND.getMessage());
    }
}
