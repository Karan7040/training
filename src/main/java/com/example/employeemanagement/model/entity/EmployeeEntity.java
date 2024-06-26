package com.example.employeemanagement.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "EMPLOYEE_DATA")

public class EmployeeEntity {
    @Id
    @Column(name = "EMP_ID")
    @NotNull(message = "Id should be an Integer")
    private Integer empId;

    @Column(name = "EMP_NAME")
    private String empName;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE")
    private String mobileNo;
}
