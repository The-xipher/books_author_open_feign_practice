package com.ust.service;

import com.ust.domain.Author;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getALlAuthors();
    public Author getAuthorById(String id);
    void deleteAuthorById(String id);
    Author updateAuthorById(String id,Author author);
}
