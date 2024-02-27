package com.example.apidemo.service;

import com.example.apidemo.dto.AuthorRequest;
import com.example.apidemo.dto.AuthorResponse;
import com.example.apidemo.model.Author;

import java.util.List;

public interface AuthorService {

    public Author save(AuthorRequest authorRequest);
    List<Author> findAll();
    AuthorResponse findById(Integer id);
    Author findAuthorById(Integer id);
    void delete(Integer id);
}
