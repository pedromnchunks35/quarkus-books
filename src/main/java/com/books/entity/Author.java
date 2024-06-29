package com.books.entity;

import java.util.List;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Author extends PanacheEntity {
    private UUID ID;
    private String name;
    private String description;
    private List<Book> books;
}
