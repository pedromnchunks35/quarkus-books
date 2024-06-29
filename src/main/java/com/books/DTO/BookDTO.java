package com.books.DTO;

import java.util.UUID;

import lombok.Data;
@Data
public class BookDTO {
    private UUID ID;
    private UUID ID_AUTHOR;
    private String description;
}
