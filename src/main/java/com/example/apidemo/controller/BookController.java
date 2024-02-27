package com.example.apidemo.controller;

import com.example.apidemo.dto.AuthorRequest;
import com.example.apidemo.dto.BookRequest;
import com.example.apidemo.model.Author;
import com.example.apidemo.model.Book;
import com.example.apidemo.service.AuthorService;
import com.example.apidemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody BookRequest bookRequest) {
        Book book = bookService.save(bookRequest);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody BookRequest bookRequest){
        Book result = bookService.save(bookRequest);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> books = bookService.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Integer id){

        Book book = bookService.findById(id);

        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
//        bookService.delete(id);

        return new ResponseEntity<>("Book Deleted By Id " + id, HttpStatus.NO_CONTENT);
    }

}
