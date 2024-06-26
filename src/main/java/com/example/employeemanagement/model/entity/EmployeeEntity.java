package com.example.employeemanagement.model.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "EMPLOYEE_DATA")
public class EmployeeEntity {


    @Column(name = "EMP_ID")
    @Id
    @NotNull(message = "EMPID cant be null")
    private Integer empId;

    @Column(name = "EMP_NAME")
    private String empName;


    @Column(name = "EMAIL")
    private String email;

    @Min(value = 200, message = "Minimum salary should be 200")
    @Column(name = "SALARY")
    private Double salary;

    @Size(min = 2, max = 11, message = "ENter valid mobile no")
    @Column(name = "MOBILE")
    private String mobile;

}
