package com.colruyt.springbookmanagement.controller;

import com.colruyt.springbookmanagement.entity.BookModel;
import com.colruyt.springbookmanagement.repository.BookJdbcRepository;
import com.colruyt.springbookmanagement.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookJpaController {
    @Autowired
    private final BookService bookService;
    @Autowired
    private BookJdbcRepository bookJdbcRepository;

    @GetMapping("getbook")
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("savebook")
    public BookModel insertBook(@Valid @RequestBody BookModel book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/deletebook/{id}")
    public String deleteBookById(@PathVariable Integer id) {
        int rowsAffected = bookJdbcRepository.deleteBookById(id);
        return rowsAffected > 0 ? "Book get deleted successfully" : "Failed to delete book";
    }
    @PutMapping("/updatebook/{id}")
    public String updateBookDescription(@PathVariable Integer id, @RequestBody String newDescription) {
        int rowsAffected = bookJdbcRepository.updateBookDescription(id, newDescription);
        return rowsAffected > 0 ? "Book description updated successfully" : "Failed to update book description";
    }

}
