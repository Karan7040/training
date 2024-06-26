package com.colruyt.springbookmanagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class BookJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int updateBookDescription(Integer id, String newDescription) {
        String sql = "UPDATE BOOK SET Description = ? WHERE ID = ?";
        return jdbcTemplate.update(sql, newDescription, id);
    }

    public int deleteBookById(Integer id) {
        String sql = "DELETE FROM BOOK WHERE ID = ?";
        return jdbcTemplate.update(sql, id);
    }
}
