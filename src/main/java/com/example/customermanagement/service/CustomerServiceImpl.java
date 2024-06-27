package com.example.customermanagement.service;

import com.example.customermanagement.model.dto.CustomerDto;
import com.example.customermanagement.model.entity.Customer;
import com.example.customermanagement.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private JdbcTemplate jdbcTemplate;

    @Override
    public void updateCustomer(CustomerDto newCustomer) {
        String sql = "INSERT INTO CUSTOMER (CUST_ID, ADDRESS, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, newCustomer.getCustId(), newCustomer.getAddress(), newCustomer.getFirstName(), newCustomer.getLastName());
    }

    @Override
    public void updateCustomerDetails(String custId, String address, String firstName, String lastName) {
// todo : variable conventions pls
        Optional<Customer> CustomerId = customerRepository.findById(custId);
        if (CustomerId.isPresent()) {
            Customer customer = CustomerId.get();
            customer = Customer.builder()
                    .custId(customer.getCustId())
                    .address(address)
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
            customerRepository.save(customer);

        }

    }

    @Override
    public void deleteCustomer(String custId) {
        String sql = "DELETE FROM CUSTOMER WHERE CUST_ID = ?";
        jdbcTemplate.update(sql, custId);

    }

    @Override
    public Optional<Customer> getCustomerDetails(String custId) {
        return customerRepository.findById(custId);
    }
}



