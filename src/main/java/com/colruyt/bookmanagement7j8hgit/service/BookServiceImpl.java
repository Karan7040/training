package com.colruyt.bookmanagement7j8hgit.service;

import com.colruyt.bookmanagement7j8hgit.model.BookEntity;
import com.colruyt.bookmanagement7j8hgit.repository.BookJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookJpaRepository bookJpaRepository;

    @Autowired
    public BookServiceImpl(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    @Override
    public List<BookEntity> getAllBooks() {
        return bookJpaRepository.findAll();
    }


    @Override
    public BookEntity saveBook(BookEntity book) {
        return bookJpaRepository.save(book);
    }

    @Override
    public boolean deleteBookById(Integer id) {
        return false;
    }

    @Override
    public boolean updateBookDescription(Integer id, String newDescription) {
        return false;
    }
}
