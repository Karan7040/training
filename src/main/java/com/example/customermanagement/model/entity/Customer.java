package com.example.customermanagement.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "CUSTOMER")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NonNull
    @Column(name = "CUST_ID", nullable = false)
    private String custId;

    @NotBlank
    @Column(name = "ADDRESS")
    private String address;

    @NotEmpty
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Size(min = 5, max = 10, message = "custId size must be between 5 and 10 characters")
    @Column(name = "LAST_NAME")
    private String lastName;

}
