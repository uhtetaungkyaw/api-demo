package com.example.apidemo.dto;

import com.example.apidemo.model.Author;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    private Integer id;
    private String name;
    private String topic;

    public static Author getAuthor(AuthorRequest authorRequest) {
        return new Author()
                .builder()
                .id(authorRequest.getId())
                .name(authorRequest.getName())
                .topic(authorRequest.getTopic())
                .build();
    }
}
