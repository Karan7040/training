package com.colruyt.productmanagementsvc.repository;

import com.colruyt.productmanagementsvc.model.dto.UpdateProductDto;
import com.colruyt.productmanagementsvc.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository

public class ProductJdbcRepository {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public ProductJdbcRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public int insertProduct(Product product) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("pid", product.getPid())
                .addValue("pgst", product.getPgst()).addValue("pcode", product.getPcode())
                .addValue("pdisc", product.getPdisc()).addValue("pcost", product.getPcost());
        return namedParameterJdbcTemplate.update("insert into PRODUCTS VALUES(:pid,:pcode,:pcost,:pdisc,:pgst)", sqlParameterSource);
    }


    public int updateProductWithPid(String productId, UpdateProductDto updateProductDto) {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("pid", productId).addValue("pcode", updateProductDto.getProductCode())
                .addValue("pcost", updateProductDto.getProductCode());
        return namedParameterJdbcTemplate.update("update PRODUCTS SET PCODE=:pcode,PCOST=:pcost WHERE PID=:pid", sqlParameterSource);
    }
}
