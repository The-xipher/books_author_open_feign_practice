package com.ust.controller;


import com.ust.converter.AuthorConverter;
import com.ust.dto.AuthorDto;
import com.ust.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Author")

public class AuthorController {

   private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto dto){
       var author=service.createAuthor(AuthorConverter.toAuthor);
       return ResponseEntity.status(HttpStatus.CREATED).body(AuthorConverter.fromEntity(author));

    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        var authors = service.getALlAuthors();
        if(authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AuthorConverter.toDtos(authors));
    }
}

