package com.ust.converter;

import com.ust.domain.Author;
import com.ust.dto.AuthorDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorConverter {

    public static Author toAuthor;

    public static List<AuthorDto> toDtos(List<Author> authors) {
        return authors.stream().map(AuthorConverter::fromEntity).toList();
    }

    public static Author toEntity(AuthorDto AuthorDto) {
        return Author.builder().id(AuthorDto.id()).fullName(AuthorDto.fullName())
                .build();
    }

    public Author toAuthor(AuthorDto dto) {
        String fullName=dto.getfullName();
        return new Author(fullName);
    }

    public static AuthorDto fromEntity(Author Author) {
        return new AuthorDto(Author.getId(), Author.getFullName());
    }
}
