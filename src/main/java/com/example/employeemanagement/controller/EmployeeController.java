package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.service.EmployeeServiceImplementation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employees")
public class EmployeeController {
    // todo : swagger is missing
    @Autowired
    private EmployeeServiceImplementation employeeService;

    // todo : alldetails? world's whole details?
    //FETCHING DETAILS
    @GetMapping("/alldetails")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.findAll();
    }

    // todo : add? sugar?
    // todo : using entity in controller?
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
