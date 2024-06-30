/* package com.books.service.Book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.books.DTO.BookDTO;
import com.books.entity.Book;
import com.books.mapper.BookMapper;

import io.quarkus.test.InjectMock;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class BookServiceTest {
    @InjectMock
    BookService bookService;
    @Mock
    BookRepository BookRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createBook_test() {
        BookDTO Book = new BookDTO();
        Book.setDescription("O martins é um rei");
        Book Book_db = BookMapper.INSTANCE.dtoToEntity(Book);
        doNothing().when(BookRepository).persist(Book_db);
        Boolean response = bookService.createBook(Book);
        assertEquals(response, true);
        verify(BookRepository, times(1)).persist(Book_db);
    }

    @Test
    public void updateBook_test() {
        BookDTO existingBook = new BookDTO();
        existingBook.setID(Long.valueOf(1));
        existingBook.setDescription("Elsa");
        Book existingBookEntity = BookMapper.INSTANCE.dtoToEntity(existingBook);
        existingBookEntity.persist();
        BookDTO updatedBook = existingBook;
        updatedBook.setDescription("Pai");
        Boolean result = bookService.updateBook(updatedBook);
        assertEquals(result, true);
    }

    @Test
    public void deleteBook_test() {
        BookDTO existingBook = new BookDTO();
        existingBook.setID(Long.valueOf(1));
        existingBook.setDescription("Elsa");
        Book Book = BookMapper.INSTANCE.dtoToEntity(existingBook);
        Book.persist();
        Boolean result = bookService.deleteBook(existingBook);
        assertEquals(result, true);
    }

    @Test
    public void getBookById_test() {
        BookDTO existingBook = new BookDTO();
        existingBook.setID(Long.valueOf(1));
        existingBook.setDescription("Elsa");
        Book Book = BookMapper.INSTANCE.dtoToEntity(existingBook);
        Book.persist();
        BookDTO sameBook = bookService.getBookById(Long.valueOf(1));
        assertEquals(existingBook, sameBook);
    }

    @Test
    public void getAllBooks_test() {
        List<BookDTO> Books = new ArrayList<BookDTO>();
        BookDTO singleBook = new BookDTO();
        singleBook.setDescription("Test");
        singleBook.setDescription("Elsa");
        for (int i = 0; i < 11; i++) {
            Books.add(singleBook);
        }
        int pageNumber = 0;
        int size = 11;
        List<Book> Books_entity = BookMapper.INSTANCE.dtosToEntities(Books);
        BookRepository.persist(Books_entity);
        List<BookDTO> BooksFromService = bookService.getAllBooks(pageNumber, size);
        assertEquals(BooksFromService, Books);
    }
}
 */