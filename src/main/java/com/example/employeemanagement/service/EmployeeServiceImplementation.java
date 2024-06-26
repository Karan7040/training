package com.example.employeemanagement.service;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import com.example.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImplementation {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //FETCHING ALL DETAILS USING JDBC
    public List<EmployeeEntity> findAll() {
        String sql = "SELECT * FROM EMPLOYEE_DATA";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new EmployeeEntity(rs.getInt("EMP_ID"),


                        rs.getString("EMP_NAME"),
                        rs.getString("EMAIL"),
                        rs.getDouble("SALARY"),
                        rs.getString("MOBILE")
                ));
    }


    //INSERTING INTO THE TABLE USING JDBC
    public void insert(EmployeeEntity employee) {
        String sql = "INSERT INTO EMPLOYEE_DATA (EMP_ID, EMP_NAME, EMAIL, SALARY, MOBILE) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, employee.getEmpId(), employee.getEmpName(), employee.getEmail(), employee.getSalary(), employee.getMobile());
    }

    // UPDATING USING JPQL  USING @QUERY
    public void updateEmployeeById(int empId, String empName, String email, double salary, String mobile) {
        employeeRepository.updateEmployeeById(empId, empName, email, salary, mobile);
    }

    //DELETING USING NATIVE SQL QUERY USING @QUERY
    public void deleteEmployeeById(int empId) {
        employeeRepository.deleteEmployeeById(empId);
    }

}