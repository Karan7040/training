package com.example.customermanagement.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
// todo : good
public enum ErrorMessage {
    CUSTOMER_NOT_FOUND("Customer does not exist");
    private final String message;
}
