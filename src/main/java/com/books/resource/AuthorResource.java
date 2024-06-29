package com.books.resource;

import java.util.UUID;

import com.books.DTO.AuthorDTO;
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
    public Response createAuthor(AuthorDTO authorDTO) {
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateAuthor(@PathParam("id") UUID id, AuthorDTO authorDTO) {
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deteleAuthor(@PathParam("id") UUID id) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{id}")
    public Response getAuthorById(@PathParam("id") UUID id) {
        return Response.status(Response.Status.OK).build();
    }

    @GET
    @Path("/{pageNumber}/{size}")
    public Response getAllAuthors(@PathParam("pageNumber") int pageNumber, @PathParam("size") int size) {
        return Response.status(Response.Status.OK).build();
    }
}
