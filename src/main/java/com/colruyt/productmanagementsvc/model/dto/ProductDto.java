package com.colruyt.productmanagementsvc.model.dto;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @NotNull
    @Size(max = 1, min = 1, message = "PID should contain only 4 characters")
    private String productId;
    @Size(max = 4, min = 4, message = "PCODE should contain only 4 characters")
    private String productCode;

    @Size(max = 4, min = 4, message = "PCOST should contain only 4 characters")
    private String productCost;

    @Size(max = 4, min = 4, message = "PDISC should contain only 4 characters")
    private String productDisc;

    @Size(max = 4, min = 4, message = "PGST should contain only 4 characters")
    private String productGst;
}
