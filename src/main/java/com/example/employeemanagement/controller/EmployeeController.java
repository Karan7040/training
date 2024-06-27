package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import com.example.employeemanagement.service.EmployeeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// todo : use construction injection, where is swagger, where is exception handlin?
public class EmployeeController {
// todo : if using ServiceImpl then why to create interface?
    @Autowired
    private EmployeeServiceImpl employeeService;
// todo : what repository is doing here
    @Autowired
    private EmployeeRepository employeeRepository;
// todo : use small case for urls
    @PostMapping("/updateDetails")
    public void update() {
        employeeService.updateEmployeeDetail();
    }

    @GetMapping("/getAllDetails/{name}")
    public List<EmployeeEntity> getAllDetails(@PathVariable String name) {
        return employeeRepository.getName(name);
    }
// todo : deleteDatas? Data is already plural.. and we always delete data only
    @PostMapping("/deleteAllDetails/{id}")
    public void deleteDatas(@Valid @PathVariable Integer id) {
        employeeRepository.delete(id);
    }
    // todo : if updating then use PutMapping
    @PostMapping("/updateNameById/{id}/{name}")
    public void updateName(@PathVariable Integer id, @PathVariable String name) {
        employeeService.updateEmployeeName(id, name);
    }


}
