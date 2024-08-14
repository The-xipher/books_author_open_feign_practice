package com.ust.service;

import com.ust.domain.Author;
import com.ust.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class AuthorServiceImpl implements AuthorService{
    private final AuthorRepository repository;

    public AuthorServiceImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Author createAuthor(Author author) {
        return repository.save(author);
    }

    @Override
    public List<Author> getALlAuthors() {
        return repository.findAll();
    }

    @Override
    public Author getAuthorById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void deleteAuthorById(String id) {
        repository.deleteById(id);

    }

    @Override
    public Author updateAuthorById(String id) {
        Author author=getAuthorById(id);
        return repository.save(author);
    }
}
