package org.example.customermanagementsvc.service;

import lombok.AllArgsConstructor;
import org.example.customermanagementsvc.model.entity.Customer;
import org.example.customermanagementsvc.repository.CustomerDao;
import org.example.customermanagementsvc.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    private CustomerDao customerDao;

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();

    }

    @Override
    public Optional<Customer> getCustomerById(String custId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);
        if (optionalCustomer.isPresent()) {
            return customerRepository.findById(custId);
        } else {
            throw new IllegalArgumentException("customerId not found");
        }
    }

    @Override
    public void updateCustomer(Customer updateCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(updateCustomer.getCustId());
        if (optionalCustomer.isEmpty()) {
            customerRepository.save(updateCustomer);
        } else {
            throw new IllegalArgumentException("Customer with ID already found");
        }
    }

    @Override
    public void updateCustomerById(String custId, String firstName, String lastName, String address) {
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);

        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddress(address);
            customerRepository.save(customer);

        } else {
            throw new IllegalArgumentException("Customer with ID not found");
        }
    }

    @Override
    public void deleteCustomer(String custId) {
        customerRepository.deleteById(custId);
    }
}
