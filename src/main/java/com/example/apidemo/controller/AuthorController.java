package com.example.apidemo.controller;

import com.example.apidemo.dto.AuthorRequest;
import com.example.apidemo.dto.AuthorResponse;
import com.example.apidemo.model.Author;
import com.example.apidemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody AuthorRequest authorRequest){
        Author result = authorService.save(authorRequest);

        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping
    public ResponseEntity<Author> updateAuthor(@RequestBody AuthorRequest authorRequest){
        Author result = authorService.save(authorRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Author>> showAuthor(){
        List<Author> authors = authorService.findAll();

        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorResponse> showAuthorDetail(@PathVariable Integer id){

        final AuthorResponse response = authorService.findById(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id) {
        authorService.delete(id);

        return new ResponseEntity<>("Author Deleted By Id " + id, HttpStatus.NO_CONTENT);
    }
}
