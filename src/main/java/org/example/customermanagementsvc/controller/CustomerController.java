package org.example.customermanagementsvc.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.customermanagementsvc.dto.CustomerDto;
import org.example.customermanagementsvc.model.entity.Customer;
import org.example.customermanagementsvc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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

@RestController
@AllArgsConstructor
@Validated
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    private NamedParameterJdbcTemplate template;

    @GetMapping("/get_customer")
    public List<CustomerDto> getCustomers() {

        List<CustomerDto> customerList = template.query("SELECT * FROM CUSTOMER", (rs, row) -> {
            return CustomerDto.builder()
                    .custId(rs.getString("custId"))
                    .firstName(rs.getString("firstName"))
                    .lastName(rs.getString("lastName"))
                    .address(rs.getString("address"))
                    .build();
        });
        return customerList;
    }

    @GetMapping("/get_customer/{custId}")
    public CustomerDto getCustomerById(@Valid @PathVariable(name = "custId") String custId) {
        CustomerDto customer = (CustomerDto) template.query("SELECT * FROM CUSTOMER WHERE CUST_ID = custId", (rs, row) -> {
            return CustomerDto.builder()
                    .custId(rs.getString("custId"))
                    .firstName(rs.getString("firstName"))
                    .lastName(rs.getString("lastName"))
                    .address(rs.getString("address"))
                    .build();
        });
        return customer;
    }

    @PostMapping("/update_customer")
    public void addCustomer(@Valid @RequestBody Customer updateCustomer) {
        customerService.updateCustomer(updateCustomer);
    }

    @PutMapping("/update_customer/{custId}")
    public void updateExistingCustomer(@Valid @PathVariable(name = "custId") String custId, @Valid @RequestParam String firstName, @Valid @RequestParam String lastName, @Valid @RequestParam String address) {
        customerService.updateCustomerById(custId, firstName, lastName, address);
    }

    @DeleteMapping("/delete_customer/{id}")
    public void deleteCustomerById(@Valid @PathVariable(name = "id") String custId) {
        customerService.deleteCustomer(custId);
    }
}
