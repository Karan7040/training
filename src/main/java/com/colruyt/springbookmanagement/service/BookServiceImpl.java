package com.colruyt.springbookmanagement.service;

import com.colruyt.springbookmanagement.entity.BookModel;
import com.colruyt.springbookmanagement.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class BookServiceImpl implements BookService{
    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Override
    public List<BookModel> getAllBooks() {
        return bookJpaRepository.findAll();
    }

    @Override
    public BookModel saveBook(BookModel book) {
        return bookJpaRepository.save(book);
    }
}
