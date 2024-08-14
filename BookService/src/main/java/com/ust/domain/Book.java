package com.ust.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "books")
public class Book {
    String id;
    String title;
    String authorId;

    public Book(String title, String authorId) {
        this.title=title;
        this.authorId=authorId;
    }
}
