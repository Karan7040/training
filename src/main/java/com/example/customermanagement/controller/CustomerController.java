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
// todo : either use autorwier or constructor not both
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/get_customer_details/{custId}")
    public Optional<Customer> getCustomerDetails(@PathVariable(name = "custId") String custId) {
        // todo : good that you wrapped with Optional
        return Optional.ofNullable(customerService.getCustomerDetails(custId).orElseThrow(CustomerNotFoundException::new));
    }
// todo : prfered small case for urls
    @PutMapping(value = "/update_customer")
    public void updateCustomer(CustomerDto newCustomer) {
        customerService.updateCustomer(newCustomer);
    }

    @DeleteMapping("/delete_customer/{custId}")
    public void deleteCustomer(@PathVariable(name = "custId") String custId) {
        customerService.deleteCustomer(custId);
    }

    // todo ; not more than 3 parameters in method
    @PostMapping("/update_customer_details/{custId}")
    public void updateCustomerDetails(@PathVariable String custId,
                                      @RequestBody CustomerDto customerDTO) {
        customerService.updateCustomerDetails(custId,
                customerDTO.getAddress(),
                customerDTO.getFirstName(),
                customerDTO.getLastName());

    }



}




