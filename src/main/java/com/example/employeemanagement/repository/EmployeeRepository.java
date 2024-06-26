package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
    @Query("UPDATE EmployeeEntity e SET e.empName = :empName, e.email = :email, e.salary = :salary, e.mobile = :mobile WHERE e.empId = :empId")
    public void updateEmployeeById(int empId, String empName, String email, double salary, String mobile);


    @Query(value = "DELETE FROM EMPLOYEE_DATA WHERE EMP_ID = :empId", nativeQuery = true)
    public void deleteEmployeeById(int empId);
}


