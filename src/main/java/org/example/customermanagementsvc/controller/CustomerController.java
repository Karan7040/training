package org.example.customermanagementsvc.controller;

import lombok.AllArgsConstructor;
import org.example.customermanagementsvc.model.entity.Customer;
import org.example.customermanagementsvc.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@Validated
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerService;

    @GetMapping("/getcustomer")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/getcustomer/{custId}")
    public Optional<Customer> getCustomerById(@PathVariable(name = "custId") String custId) {
        return customerService.getCustomerById(custId);
    }

    @PostMapping("/updatecustomer")
    public void addCustomer(@RequestBody Customer updateCustomer) {
        customerService.updateCustomer(updateCustomer);
    }

    @PutMapping("/updatecustomer/{id}")
    public void updateExistingCustomer(@PathVariable(name = "custId") String custId, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String address) {
        customerService.updateCustomerById(custId, firstName, lastName, address);
    }

    @DeleteMapping("/deletecustomer/{id}")
    public void deleteCustomerById(@PathVariable(name = "custId") String custId) {
        customerService.deleteCustomer(custId);
    }
}
