package com.books.DTO;

import java.util.List;
import java.util.UUID;

import lombok.Data;
@Data
public class AuthorDTO {
    private UUID ID;
    private String name;
    private String description;
    private List<BookDTO> books;
}
