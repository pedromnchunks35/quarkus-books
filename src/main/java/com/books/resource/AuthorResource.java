package com.books.resource;

import java.util.List;

import com.books.DTO.AuthorDTO;
import com.books.entity.Author;
import com.books.service.Author.AuthorService;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

@Path("/Author")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {

    @Inject
    AuthorService authorService;

    @POST
    public Response createAuthor(Author author) {
        Boolean created = authorService.createAuthor(author);
        if (!created) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(author).status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") Long id, Author new_author) {
        new_author.setId(id);
        authorService.updateAuthor(new_author);
        return Response.ok(new_author).status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deteleAuthor(@PathParam("id") Long id) {
        Author author_to_delete = authorService.getAuthorById(id);
        authorService.deleteAuthor(author_to_delete);
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") Long id) {
        Author auth = authorService.getAuthorById(id);
        return Response.ok(auth).status(Response.Status.OK).build();
    }

    @GET
    @Path("/{pageNumber}/{size}")
    public Response getAllAuthors(@PathParam("pageNumber") int pageNumber, @PathParam("size") int size) {
        List<Author> authors = authorService.getAllAuthors(pageNumber, size);
        return Response.ok(authors).status(Response.Status.OK).build();
    }
}
