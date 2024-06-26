package org.example.customermanagementsvc.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CUSTOMER")
public class Customer implements Serializable {
//
//    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "CUST_ID", nullable = false)
    @NotNull(message = "CUSTOMER ID SHOULD NOT BE BLANK")
    private String custId;

    @Column(name = "ADDRESS")
    @NotBlank(message = "ADDRESS SHOULD NOT BE EMPTY")
    private String address;

    @Column(name = "FIRST_NAME")
    @NotBlank(message = "FIRSTNAME SHOULD NOT BE EMPTY")
    private String firstName;

    @Column(name = "LAST_NAME")
    @NotBlank(message = "LASTNAME SHOULD NOT BE EMPTY")
    private String lastName;

}
