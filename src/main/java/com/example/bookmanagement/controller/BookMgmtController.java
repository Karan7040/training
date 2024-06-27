package com.example.bookmanagement.controller;


import com.example.bookmanagement.model.bookmgmtdto.BookMgmtDto;
import com.example.bookmanagement.service.BookMgmtService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Controller
@Getter
@Setter
@RestController
// todo : why getter? ,if using setter then why @autorwired.?
// todo : if using RestController then why Controller
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
    // todo: handle not found in exception handler
    public ResponseEntity<BookMgmtDto> getBookById(@PathVariable long id) {
        Optional<BookMgmtDto> book = bookMgmtService.getBookById(id);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
// todo : small case for url
    @GetMapping("/{Id}")
    public ResponseEntity<BookMgmtDto> updateBook(@PathVariable long id, @RequestBody BookMgmtDto BookMgmtDto) {
        Optional<BookMgmtDto> book = bookMgmtService.updateBook(id, BookMgmtDto);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }
    // todo : use wrapper Void
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
