/* package com.books.resource;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import com.books.DTO.BookDTO;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@QuarkusTest
public class BookResourceTest {
    @Test
    public void createBook_test() {
        BookDTO book = new BookDTO();
        book.setDescription("Martins, o sabio");
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(book)
                .when()
                .post("/Book")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode());
    }

    @Test
    public void updateBook_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .put("/Book/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void deleteBook_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .delete("/Book/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void getBookById_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when()
                .get("/Book/{id}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    public void getAllBooks_test() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("pageNumber", 1)
                .pathParam("size", 3)
                .when()
                .get("/Book/{pageNumber}/{size}")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }
}
 */