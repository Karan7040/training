package com.example.employeemanagement.service;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public List<EmployeeEntity> findAll();
    public void updateEmployeeById(int empId, String empName, String email, double salary, String mobile);
    public void deleteEmployeeById(int empId);
}
