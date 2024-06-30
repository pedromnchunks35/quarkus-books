/* package com.books.resource;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.books.DTO.AuthorDTO;
import com.books.DTO.BookDTO;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class AuthorResourceTest {
    @Test
    public void createAuthor_test() {
        AuthorDTO author = new AuthorDTO();
        author.setDescription("Martins, o sabio");
        author.setName("Martins");
        List<BookDTO> books = new ArrayList<BookDTO>();
        BookDTO book = new BookDTO();
        book.setDescription("A biblia");
        books.add(book);
        author.setBooks(books);
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(book)
                .when()
                .post("/Author")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    public void updateAuthor_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .put("/Author/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void deleteAuthor_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .delete("/Author/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void getAuthorById_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/Author/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void getAllAuthors_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("pageNumber", 1)
                .pathParam("size", 3)
                .when()
                .get("/Author/{pageNumber}/{size}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
 */