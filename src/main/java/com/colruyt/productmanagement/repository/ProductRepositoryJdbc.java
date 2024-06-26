package com.colruyt.productmanagement.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryJdbc {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int updateName( String pid, String pcode,String pcost, String pdisc,String pgst)
    {
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource()
                .addValue("pid", pid)
                .addValue("pcode",pcode)
                .addValue("pcost",pcost)
                .addValue("pdisc",pdisc)
                .addValue("pqst",pgst);
        return namedParameterJdbcTemplate
                .update("UPDATE PRODUCTS SET PCODE=:pcode,PCOST=:pcost,PDISC=:pdisc,PGST=:pqst WHERE PID=:pid", sqlParameterSource);


    }

    public Boolean deleteName(String id)
    {
        SqlParameterSource sqlParameterSource=new MapSqlParameterSource().addValue("pid",id);
        int product=namedParameterJdbcTemplate
                .update("DELETE FROM PRODUCTS WHERE PID=:pid", sqlParameterSource);
        return product>1;

    }

}
