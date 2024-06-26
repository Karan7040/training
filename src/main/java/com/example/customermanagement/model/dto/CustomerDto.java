package com.example.customermanagement.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomerDto {
    @NotNull(message = "custId must not be null")
    @Size(min = 5, max = 10, message = "custId size must be between 5 and 10 characters")
    private String custId;

    private String address;

    private String firstName;

    private String lastName;
}
