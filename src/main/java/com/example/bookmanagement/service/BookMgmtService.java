package com.example.bookmanagement.service;

import com.example.bookmanagement.model.bookmgmtdto.BookMgmtDto;

import java.util.List;
import java.util.Optional;

public interface BookMgmtService {
// check the implementation.. seems like.. no connection

    BookMgmtDto createBook(BookMgmtDto bookMgmtDto);


    List<BookMgmtDto> getAllbooks();

    Optional<BookMgmtDto> getBookById(long id);

    Optional<BookMgmtDto> updateBook(long id, BookMgmtDto bookMgmtDto);

    boolean deleteBook(long id);
}
