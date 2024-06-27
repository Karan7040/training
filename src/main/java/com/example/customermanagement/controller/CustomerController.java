package com.example.customermanagement.controller;

import com.example.customermanagement.exception.CustomerNotFoundException;
import com.example.customermanagement.model.dto.CustomerDto;
import com.example.customermanagement.model.entity.Customer;
import com.example.customermanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/customer")
// todo : either use autorwier or constructor not both
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomerDetails/{custId}")
    public Optional<Customer> getCustomerDetails(@PathVariable(name = "custId") String custId) {
        // todo : good that you wrapped with Optional
        return Optional.ofNullable(customerService.getCustomerDetails(custId).orElseThrow(CustomerNotFoundException::new));
    }
// todo : prfered small case for urls
    @PutMapping(value = "/updateCustomer")
    public void updateCustomer(CustomerDto newCustomer) {
        customerService.updateCustomer(newCustomer);
    }

    @DeleteMapping("/deleteCustomer/{custId}")
    public void deleteCustomer(@PathVariable(name = "custId") String custId) {
        customerService.deleteCustomer(custId);
    }

    // todo ; not more than 3 parameters in method
    @PostMapping("/updateCustomerDetails/{custId}")
    public void updateCustomerDetails(@PathVariable String custId,
                                      @RequestParam String address,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName) {
        customerService.updateCustomerDetails(custId, address, firstName, lastName);
    }


}




