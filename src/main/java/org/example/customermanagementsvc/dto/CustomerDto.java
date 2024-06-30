package org.example.customermanagementsvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import jakarta.validation.constraints.*;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    @NotNull(message = "CUSTOMER ID SHOULD NOT BE BLANK")
    private String custId;

    @NotBlank(message = "ADDRESS SHOULD NOT BE EMPTY")
    private String address;

    @NotBlank(message = "FIRSTNAME SHOULD NOT BE EMPTY")
    private String firstName;

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @NotBlank(message = "LASTNAME SHOULD NOT BE EMPTY")
    private String lastName;
}
