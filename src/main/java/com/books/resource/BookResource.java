package com.books.resource;

import java.util.UUID;

import com.books.DTO.BookDTO;
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
    public Response createBook(BookDTO BookDTO) {
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") UUID id, BookDTO BookDTO) {
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deteleBook(@PathParam("id") UUID id) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") UUID id) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{pageNumber}/{size}")
    public Response getAllBooks(@PathParam("pageNumber") int pageNumber, @PathParam("size") int size) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorByBook(@PathParam("id") UUID id) {
        return Response.status(Response.Status.OK).build();
    }
}
