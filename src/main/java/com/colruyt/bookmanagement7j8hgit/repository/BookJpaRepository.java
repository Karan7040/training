package com.colruyt.bookmanagement7j8hgit.repository;

import com.colruyt.bookmanagement7j8hgit.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookJpaRepository extends JpaRepository<BookEntity, Integer> {
}
