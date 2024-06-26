package com.example.employeemanagement.service;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void updateEmployeeDetail() {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("empId", "6").addValue("empName", "Surya").addValue("salary", "6000").addValue("email", "sur@gmail.com").addValue("mobileNo", "9512364721");
        namedParameterJdbcTemplate.update("insert into EMPLOYEE_DATA(EMP_ID,EMP_NAME,SALARY,EMAIL,MOBILE) values(:empId,:empName,:salary,:email,:mobileNo)", sqlParameterSource);


    }

    public void updateEmployeeName(Integer id, String newName) {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            EmployeeEntity employee = optionalEmployee.get();
            employee.setEmpName(newName);
            employeeRepository.save(employee);
        }
    }


}
