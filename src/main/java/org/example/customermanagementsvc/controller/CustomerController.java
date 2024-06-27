package org.example.customermanagementsvc.controller;

import lombok.AllArgsConstructor;
import org.example.customermanagementsvc.model.entity.Customer;
import org.example.customermanagementsvc.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
public class CustomerController {
    // TODO : USE RESPONSEENTITY FOR ALL THE RETURN TYPES
    // TODO : either use AllArgsConstructor/Autowired (preferred Constructor Injection)
    @Autowired
    // TODO : What's the point of injection ServiceImpl when youhave interface
    private CustomerServiceImpl customerService;

    // TODO : use get_customer
    @GetMapping("/getcustomer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    // TODO : SAME HERE
    @GetMapping("/getcustomer/{custId}")
    public Optional<Customer> getCustomerById(@PathVariable(name = "custId") String custId) {
        return customerService.getCustomerById(custId);
    }

    // TODO : WHY DO YOU ENTITY IN THE CONTORLLER LAYER
    // todo : use @Valid
    @PostMapping("/updatecustomer")
    public void addCustomer(@RequestBody Customer updateCustomer) {
        customerService.updateCustomer(updateCustomer);
    }

    // todo : use update_customer
    // todo ; better to use query params instead of path variable when having null values for parameters
    @PutMapping("/updatecustomer/{id}")
    public void updateExistingCustomer(@PathVariable(name = "custId") String custId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        customerService.updateCustomerById(custId, firstName, lastName, address);
    }
// todo : use delete_customer
    @DeleteMapping("/deletecustomer/{id}")
    public void deleteCustomerById(@PathVariable(name = "id") String custId) {
        customerService.deleteCustomer(custId);
    }
}
