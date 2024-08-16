package com.ust.controller;


import com.ust.converter.AuthorConverter;
import com.ust.domain.Author;
import com.ust.dto.AuthorDto;
import com.ust.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/author")

public class AuthorController {

   private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto dto){
        Author author;
        author = new Author();
        author.setFullName(dto.fullName());
       var temp=service.createAuthor(author);
       return ResponseEntity.status(HttpStatus.CREATED).body(AuthorConverter.fromEntity(temp));

    }

    @GetMapping
    @Operation(summary = "Get all authors", description = "")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author returned successfully"),
            @ApiResponse(responseCode = "404", description = "Author not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        var authors = service.getALlAuthors();
        if(authors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(AuthorConverter.toDtos(authors));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable String id){
        var author=service.getAuthorById(id);
        return ResponseEntity.ok().body(author);
    }
}

