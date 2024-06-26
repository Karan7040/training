package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.dto.EmployeeDTO;
import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeService;
import com.example.employeemanagement.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/updateDetails")
    public void update(){
        employeeService.updateEmployeeDetail();
    }
    @GetMapping("/getAllDetails/{name}")
    public List<EmployeeEntity> getAllDetails(@PathVariable String name){
        return employeeRepository.getName(name);
    }
    @PostMapping("/deleteAllDetails/{id}")
    public void deleteDatas(@Valid @PathVariable Integer id){
        employeeRepository.delete(id);
    }
    @PostMapping("/updateNameById/{id}/{name}")
    public void updateName(@PathVariable Integer id,@PathVariable String name){
        employeeService.updateEmployeeName(id, name);
    }






}
