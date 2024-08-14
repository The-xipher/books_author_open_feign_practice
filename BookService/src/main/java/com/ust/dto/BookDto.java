package com.ust.dto;

import com.ust.domain.Book;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record BookDto(
        String id,
        @NotEmpty(message = "title cannot  be empty")
        String title
        ,@NotEmpty(message = "authorId cannot be empty")
        String authorId) {
        public static List<BookDto> toDtos(List<Book> Books) {
                return Books.stream().map(BookDto::fromEntity).toList();
        }
        public Book toEntity(BookDto dto) {

                return Book.builder().title(dto.title).authorId(dto.authorId).build();
        }

        public Book toBook() {
                return new Book(title,authorId);
        }

        public static BookDto fromEntity(Book Book) {
                return new BookDto(Book.getId(), Book.getTitle(),Book.getAuthorId());
        }
}
