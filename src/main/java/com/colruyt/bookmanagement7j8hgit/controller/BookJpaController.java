package com.colruyt.bookmanagement7j8hgit.controller;


import com.colruyt.bookmanagement7j8hgit.model.BookEntity;
import com.colruyt.bookmanagement7j8hgit.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookJpaController {

    private final BookService bookService;

    @GetMapping("/getBooks")
    public List<BookEntity> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/saveBooks")
    public BookEntity insertBook(@Valid @RequestBody BookEntity book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBookById(@PathVariable Integer id) {
        boolean deleted = bookService.deleteBookById(id);
        return deleted ? "Book deleted successfully" : "Failed to delete book";
    }

    @PutMapping("/update/{id}")
    public String updateBookDescription(@PathVariable Integer id, @RequestBody String newDescription) {
        boolean updated = bookService.updateBookDescription(id, newDescription);
        return updated ? "Book description updated successfully" : "Failed to update book description";
    }
}
