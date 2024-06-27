package com.colruyt.springbookmanagement.repository;

import com.colruyt.springbookmanagement.entity.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

// todo : is this a spring class? if yes where is annotation?
public interface BookJpaRepository extends JpaRepository<BookModel,Integer> {
}
