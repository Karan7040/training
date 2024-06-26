package com.example.bookmanagement.service;


import com.example.bookmanagement.model.bookmgmtdto.BookMgmtDto;
import com.example.bookmanagement.model.bookmgmtdto.entity.BookMgmtEntity;
import com.example.bookmanagement.respository.BookMgmtRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl  implements BookMgmtService {

    @Autowired
    private BookMgmtRepository bookMgmtRepository;


    public BookMgmtDto createBook(BookMgmtDto bookMgmtDto) {
        BookMgmtEntity bookMgmtEntity = new BookMgmtEntity(); bookMgmtEntity.setName(bookMgmtDto.getName()); bookMgmtEntity.setDescription(bookMgmtDto.getDescription());
        bookMgmtEntity = bookMgmtRepository.save(bookMgmtEntity); bookMgmtDto.setId(bookMgmtEntity.getId());
        return bookMgmtDto;
    }

    public List<BookMgmtDto> getAllBooks() {
        List<BookMgmtEntity> books = bookMgmtRepository.findAll();
        return books.stream().map(book -> { BookMgmtDto bookMgmtDto = new BookMgmtDto();
            bookMgmtDto.setId(book.getId()); bookMgmtDto.setName(book.getName()); bookMgmtDto.setDescription(book.getDescription());
            return bookMgmtDto; }).collect(Collectors.toList());
    }

    public Optional<BookMgmtDto> getBookById(Long id) {
        Optional<BookMgmtEntity> book = bookMgmtRepository.findById(id);
        if (book.isPresent()) { BookMgmtEntity bookMgmtEntity = book.get(); BookMgmtDto bookMgmtDto = new BookMgmtDto(); bookMgmtDto.setId(bookMgmtEntity.getId());
            bookMgmtDto.setName(bookMgmtEntity.getName()); bookMgmtDto.setDescription(bookMgmtEntity.getDescription());
            return Optional.of(bookMgmtDto);
        }
        return Optional.empty();
    }


    public Optional<BookMgmtDto> updateBook(Long id, BookMgmtDto bookMgmtDto) {
        Optional<BookMgmtEntity> book = bookMgmtRepository.findById(id);
        if (book.isPresent()) {
            BookMgmtEntity bookMgmtEntity = book.get();
            bookMgmtEntity.setName(bookMgmtDto.getName());
            bookMgmtEntity.setDescription(bookMgmtDto.getDescription());
            bookMgmtEntity = bookMgmtRepository.save(bookMgmtEntity);
            bookMgmtDto.setId(bookMgmtEntity.getId());
            return Optional.of(bookMgmtDto);
        }
        return Optional.empty();
    }

    public boolean deletebook(Long id) {
        Optional<BookMgmtEntity> book = bookMgmtRepository.findById(id);
        if (book.isPresent()) {
            bookMgmtRepository.delete(book.get());
            return true;
        }
        return false;
    }


}
