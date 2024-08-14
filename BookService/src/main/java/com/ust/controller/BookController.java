package com.ust.controller;


import com.ust.dto.Author;
import com.ust.dto.BookDto;
import com.ust.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<BookDto> createAuthor(@RequestBody BookDto dto){
        var author=service.createBook(dto.toBook());
        return ResponseEntity.status(HttpStatus.CREATED).body(BookDto.fromEntity(author));

    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        var books = service.getAllBooks();
        if(books.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(BookDto.toDtos(books));
    }
    @GetMapping("author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable String id){

       return  ResponseEntity.ok().body(service.getAuthorById(id));
    }
}



