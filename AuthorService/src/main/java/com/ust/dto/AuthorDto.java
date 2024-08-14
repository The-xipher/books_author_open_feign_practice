package com.ust.dto;

import jakarta.validation.constraints.NotEmpty;

public record AuthorDto(

        String id,
        @NotEmpty(message = "Name Required")
        String fullName
) {
        public String getfullName() {
                return  fullName;
        }



}
