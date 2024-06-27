package org.example.customermanagementsvc.service;

import org.example.customermanagementsvc.model.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> getCustomers();

    Optional<Customer> getCustomerById(String custId);

    void updateCustomer(Customer updateCustomer);
// method parameters should not have more than 3 parameters
    void updateCustomerById(String custId, String firstName, String lastName, String address);

    void deleteCustomer(String custId);

}
