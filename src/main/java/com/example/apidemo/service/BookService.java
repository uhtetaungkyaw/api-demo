package com.example.apidemo.service;

import com.example.apidemo.dto.BookRequest;
import com.example.apidemo.model.Book;

import java.util.List;

public interface BookService {
    Book save(BookRequest bookRequest);
    List<Book> findAll();
    Book findById(Integer id);

}
