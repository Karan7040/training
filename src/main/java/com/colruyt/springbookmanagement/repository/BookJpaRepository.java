package com.colruyt.springbookmanagement.repository;

import com.colruyt.springbookmanagement.entity.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookModel,Integer> {
}
