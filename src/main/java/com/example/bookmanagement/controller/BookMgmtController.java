package com.example.bookmanagement.controller;


import com.example.bookmanagement.model.bookmgmtdto.BookMgmtDto;
import com.example.bookmanagement.service.BookMgmtService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Getter
@Setter
@RestController

public class BookMgmtController {

    @Autowired
    private BookMgmtService bookMgmtService;

    @PostMapping
    public BookMgmtDto createBook(@RequestBody BookMgmtDto bookMgmtDto) {
        return bookMgmtService.createBook(bookMgmtDto);
    }

    @GetMapping
    public List<BookMgmtDto> getAllBooks() {
        return bookMgmtService.getAllbooks();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<BookMgmtDto> getBookById(@PathVariable long id) {
        Optional<BookMgmtDto> book = bookMgmtService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{Id}")
    public ResponseEntity<BookMgmtDto> updateBook(@PathVariable long id, @RequestBody BookMgmtDto BookMgmtDto) {
        Optional<BookMgmtDto> book = bookMgmtService.updateBook(id, BookMgmtDto);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }


        @DeleteMapping("/{Id}")
        public ResponseEntity<void> deleteBook(@PathVariable Long id){
            boolean delete = bookMgmtService.deleteBook(id);
            if (delete) {
                return ResponseEntity.ok().build();
            } else {
                return ResponseEntity.notFound().build();
            }

        }

    }
    }