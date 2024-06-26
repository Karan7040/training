package com.example.employeemanagement.service;

import com.example.employeemanagement.model.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    public void updateEmployeeDetail();
    public void updateEmployeeName(Integer id,String newName);

   // public List<EmployeeEntity> getName(String name);

}
