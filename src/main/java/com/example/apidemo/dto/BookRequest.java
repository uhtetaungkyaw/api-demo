package com.example.apidemo.dto;

import com.example.apidemo.model.Book;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {
    private String bookName;
    private String publisher;
    private Integer authorId;

    public static Book getBook(BookRequest bookRequest) {
        return new Book()
                .builder()
                .bookName(bookRequest.getBookName())
                .publisher(bookRequest.getPublisher())
                .build();
    }
}
