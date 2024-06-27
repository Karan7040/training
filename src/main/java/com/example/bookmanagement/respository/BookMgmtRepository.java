package com.example.bookmanagement.respository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookMgmtRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int getUpdatebookDescription() {
        return 0;

    }

    public int updatebookDescription(){
        return 0;
    }



}
