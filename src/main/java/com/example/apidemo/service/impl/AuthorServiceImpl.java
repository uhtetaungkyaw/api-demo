package com.example.apidemo.service.impl;

import com.example.apidemo.dto.AuthorRequest;
import com.example.apidemo.dto.AuthorResponse;
import com.example.apidemo.model.Author;
import com.example.apidemo.repo.AuthorRepo;
import com.example.apidemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepo authorRepo;
    @Override
    public Author save(AuthorRequest authorRequest) {
       return authorRepo.save(AuthorRequest.getAuthor(authorRequest));
    }

    @Override
    public List<Author> findAll() {
        return authorRepo.findAll();
    }

    @Override
    public AuthorResponse findById(Integer id) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No author found"));

        AuthorResponse response = new AuthorResponse();
        response.setName(author.getName());

        return response;
    }

    @Override
    public Author findAuthorById(Integer id) {
        return authorRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id " + id));
    }

    @Override
    public void delete(Integer id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        }
    }

}
