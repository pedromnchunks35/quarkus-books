package com.books.mapper;

import org.mapstruct.Mapper;

import com.books.DTO.BookDTO;
import com.books.entity.Book;

@Mapper(componentModel = "cdi")
public interface BookMapper {
    Book dtoToEntity(BookDTO dto);

    BookDTO entityToDto(Book entity);
}
