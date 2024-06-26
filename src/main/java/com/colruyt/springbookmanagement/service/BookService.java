package com.colruyt.springbookmanagement.service;

import com.colruyt.springbookmanagement.entity.BookModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    List<BookModel> getAllBooks();
    BookModel saveBook(BookModel book);
}
