package com.books.DTO;

import java.util.List;

import lombok.Data;

@Data
public class AuthorDTO {
    private Long ID;
    private String name;
    private String description;
    private List<BookDTO> books;
}
