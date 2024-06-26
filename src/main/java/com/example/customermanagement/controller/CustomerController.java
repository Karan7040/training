package com.example.customermanagement.controller;

import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.model.dto.CustomerDto;
import com.example.customermanagement.model.entity.Customer;
import com.example.customermanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomerDetails/{custId}")
    public Optional<Customer> getCustomerDetails(@PathVariable(name = "custId") String custId) {
        return Optional.ofNullable(customerService.getCustomerDetails(custId).orElseThrow(CustomerNotFoundException::new));
    }

    @PutMapping(value = "/updateCustomer")
    public void updateCustomer(CustomerDto newCustomer) {
        customerService.updateCustomer(newCustomer);
    }

    @DeleteMapping("/deleteCustomer/{custId}")
    public void deleteCustomer(@PathVariable(name = "custId") String custId) {
        customerService.deleteCustomer(custId);
    }

    @PostMapping("/updateCustomerDetails/{custId}")
    public void updateCustomerDetails(@PathVariable String custId,
                                      @RequestParam String address,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName) {
        customerService.updateCustomerDetails(custId, address, firstName, lastName);
    }


}




