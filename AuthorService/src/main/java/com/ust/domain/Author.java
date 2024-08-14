package com.ust.domain;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "Authors")
public class Author {
    private String id;
    private String fullName;

    public Author(String fullName) {
        this.fullName=fullName;
    }
}
