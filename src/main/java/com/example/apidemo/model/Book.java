package com.example.apidemo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    private String publisher;
    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(Integer id, String bookName, String publisher, Author author) {
        this.id = id;
        this.bookName = bookName;
        this.publisher = publisher;
        this.author = author;
    }

}
