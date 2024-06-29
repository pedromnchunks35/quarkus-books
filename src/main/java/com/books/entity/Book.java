package com.books.entity;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Data;

//? Makes constructors (empty and full), getters and setters out of the box
@Data
@Entity
public class Book extends PanacheEntity {
    private UUID ID;
    private UUID ID_AUTHOR;
    private String description;
}
