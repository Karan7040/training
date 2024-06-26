package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    @Query(value = "select * from EMPLOYEE_DATA WHERE EMP_NAME = :name ", nativeQuery = true)
    List<EmployeeEntity> getName(String name);

    @Query(value = "delete from EMPLOYEE_DATA WHERE EMP_ID=:id ", nativeQuery = true)
    public void delete(Integer id);
}
