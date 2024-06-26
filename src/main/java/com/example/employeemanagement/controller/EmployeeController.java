package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.service.EmployeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImplementation employeeService;

    //FETCHING DETAILS
    @GetMapping("/alldetails")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.findAll();
    }

    //INSERTING INTO TABLE
    @PostMapping("/add")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeEntity employee) {
        employeeService.insert(employee);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    //DELETING BY ID
    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable int empId) {
        employeeService.deleteEmployeeById(empId);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
