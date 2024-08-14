package com.ust.service;

import com.ust.domain.Book;

import com.ust.repository.BookRepository;


import java.util.List;

public class BookServiceImpl implements BookService{

    private final BookRepository repository;


    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;

    }

    @Override
    public Book createBook(Book book) {
        return repository.save(book);
    }

    @Override
    public Book getBookById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }



    @Override
    public void deleteBookById(String id) {
        repository.deleteById(id);

    }

    @Override
    public Book updateAuthorById(String id,Book book) {
        Book books=getBookById(id);
        books.setTitle(book.getTitle());
        books.setAuthorId(book.getAuthorId());
        repository.save(books);
        return books;
    }
}
