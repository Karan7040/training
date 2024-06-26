package org.example.customermanagementsvc.dto;

import lombok.Data;
import jakarta.validation.constraints.*;

@Data
public class CustomerDto {
    @NotNull(message = "CUSTOMER ID SHOULD NOT BE BLANK")
    private String custId;

    @NotBlank(message = "ADDRESS SHOULD NOT BE EMPTY")
    private String address;

    @NotBlank(message = "FIRSTNAME SHOULD NOT BE EMPTY")
    private String firstName;

    @NotBlank(message = "LASTNAME SHOULD NOT BE EMPTY")
    private String lastName;
}
