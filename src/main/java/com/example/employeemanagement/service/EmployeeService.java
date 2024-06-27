package com.example.employeemanagement.service;

public interface EmployeeService {
    // call     getName and delete in the service
    public void updateEmployeeDetail();

    public void updateEmployeeName(Integer id, String newName);

    // public List<EmployeeEntity> getName(String name);

}
