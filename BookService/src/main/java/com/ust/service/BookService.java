package com.ust.service;

import com.ust.domain.Book;
import com.ust.dto.Author;

import java.util.List;

public interface BookService {
    public Book createBook(Book book);
    public Book getBookById(String id);
    List<Book>  getAllBooks();
    void deleteBookById(String id);
    Book updateAuthorById(String id,Book book);
}
