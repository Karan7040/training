package com.example.employeemanagement.service;

import com.example.employeemanagement.model.entity.EmployeeEntity;

import java.util.List;

// todo : what's the point of creating interface if not using
public interface EmployeeService {
    public List<EmployeeEntity> findAll();
    public void updateEmployeeById(int empId, String empName, String email, double salary, String mobile);
    public void deleteEmployeeById(int empId);
}
