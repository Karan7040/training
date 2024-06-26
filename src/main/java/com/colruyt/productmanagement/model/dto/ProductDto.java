package com.colruyt.productmanagement.model.dto;

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
@Size(max =4,min = 1,message = "Invalid Size")
    private String pid;

    private String pcode;

    private String pcost;

    private String pdisc;

    private String pgst;
}
