package com.colruyt.productmanagementsvc.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCTS")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PID")
    private String pid;

    @Column(name = "PCODE")
    private String pcode;

    @Column(name = "PCOST")
    private String pcost;

    @Column(name = "PDISC")
    private String pdisc;

    @Column(name = "PGST")
    private String pgst;

}
