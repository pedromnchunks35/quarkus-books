package com.books.resource;

import java.util.List;

import com.books.DTO.BookDTO;
import com.books.entity.Book;
import com.books.service.Book.BookService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("Book")
public class BookResource {
    @Inject
    BookService bookService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBook(Book book) {
        boolean success = bookService.createBook(book);
        if (!success) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(book).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") Long id, Book newBook) {
        newBook.setId(id);
        boolean success = bookService.updateBook(newBook);
        if (!success) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(newBook).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deteleBook(@PathParam("id") Long id) {
        Book bookToDelete = bookService.getBookById(id);
        boolean success = bookService.deleteBook(bookToDelete);
        if (!success) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id) {
        Book book = bookService.getBookById(id);
        return Response.ok(book).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{pageNumber}/{size}")
    public Response getAllBooks(@PathParam("pageNumber") int pageNumber, @PathParam("size") int size) {
        List<Book> books = bookService.getAllBooks(pageNumber, size);
        return Response.ok(books).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorByBook(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).build();
    }
}
