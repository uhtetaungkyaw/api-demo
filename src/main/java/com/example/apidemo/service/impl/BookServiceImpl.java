package com.example.apidemo.service.impl;

import com.example.apidemo.dto.BookRequest;
import com.example.apidemo.model.Author;
import com.example.apidemo.model.Book;
import com.example.apidemo.repo.AuthorRepo;
import com.example.apidemo.repo.BookRepo;
import com.example.apidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorRepo authorRepo;

    @Override
    public Book save(BookRequest bookRequest) {
        Book book = BookRequest.getBook(bookRequest);
        Author author = authorRepo.findById(bookRequest.getAuthorId())
                        .orElseThrow(() -> new IllegalArgumentException("Invalid ID  " + bookRequest.getAuthorId()));
        book.setAuthor(author);
        return bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID  " + id));

    }
}
