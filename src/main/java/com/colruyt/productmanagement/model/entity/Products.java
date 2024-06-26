package com.colruyt.productmanagement.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "PRODUCTS")
@SequenceGenerator(name = "PRODUCT_GEN", sequenceName = "EX_PRODUCT_SEQ", allocationSize = 1)
public class Products implements Serializable {



    @Id
    @Column(name = "PID", nullable = false)
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
