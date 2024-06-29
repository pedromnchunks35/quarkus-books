package com.books.mapper;

import org.mapstruct.Mapper;

import com.books.DTO.AuthorDTO;
import com.books.entity.Author;

@Mapper(componentModel = "cdi")
public interface AuthorMapper {
    Author dtoToEntity(AuthorDTO dto);

    AuthorDTO entityToDto(Author entity);
}
