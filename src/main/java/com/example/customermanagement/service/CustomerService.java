package com.example.customermanagement.service;

import com.example.customermanagement.model.dto.CustomerDto;
import com.example.customermanagement.model.entity.Customer;

import java.util.Optional;

public interface CustomerService {

    void updateCustomer(CustomerDto newCustomer);

    void updateCustomerDetails(String custId, String address, String firstName, String lastName);

    void deleteCustomer(String id);

    Optional<Customer> getCustomerDetails(String custId);

}
