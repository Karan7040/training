package com.colruyt.bookmanagement7j8hgit.service;


import com.colruyt.bookmanagement7j8hgit.model.BookEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    List<BookEntity> getAllBooks();
    BookEntity saveBook(BookEntity book);

    boolean deleteBookById(Integer id);

    boolean updateBookDescription(Integer id, String newDescription);
}
