/* package com.books.service.Author;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import com.books.DTO.AuthorDTO;
import com.books.entity.Author;
import com.books.mapper.AuthorMapper;

import io.quarkus.test.InjectMock;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class AuthorServiceTest {
    @Inject
    AuthorMapper authMapper;
    @InjectMock
    AuthorService authorService;
    @Mock
    AuthorRepository authorRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void createAuthor_test() {
        AuthorDTO author = new AuthorDTO();
        author.setName("Martins");
        author.setDescription("O martins é um rei");
        Author author_db = AuthorMapper.dtoToEntity(author);
        doNothing().when(authorRepository).persist(author_db);
        Boolean response = authorService.createAuthor(author);
        assertEquals(response, true);
        verify(authorRepository, times(1)).persist(author_db);
    }

    @Test
    public void updateAuthor_test() {
        AuthorDTO existingAuthor = new AuthorDTO();
        existingAuthor.setID(Long.valueOf(1));
        existingAuthor.setName("Elsa");
        Author existingAuthorEntity = AuthorMapper.dtoToEntity(existingAuthor);
        existingAuthorEntity.persist();
        AuthorDTO updatedAuthor = existingAuthor;
        updatedAuthor.setName("Pai");
        Boolean result = authorService.updateAuthor(updatedAuthor);
        assertEquals(result, true);
    }

    @Test
    public void deleteAuthor_test() {
        AuthorDTO existingAuthor = new AuthorDTO();
        existingAuthor.setID(Long.valueOf(Long.valueOf(1)));
        existingAuthor.setName("Elsa");
        Author author = AuthorMapper.dtoToEntity(existingAuthor);
        author.persist();
        Boolean result = authorService.deleteAuthor(existingAuthor);
        assertEquals(result, true);
    }

    @Test
    public void getAuthorById_test() {
        AuthorDTO existingAuthor = new AuthorDTO();
        existingAuthor.setID(Long.valueOf(1));
        existingAuthor.setName("Elsa");
        Author author = AuthorMapper.dtoToEntity(existingAuthor);
        author.persist();
        AuthorDTO sameAuthor = authorService.getAuthorById(Long.valueOf(1));
        assertEquals(existingAuthor, sameAuthor);
    }

    @Test
    public void getAllAuthors_test() {
        List<AuthorDTO> authors = new ArrayList<AuthorDTO>();
        AuthorDTO singleAuthor = new AuthorDTO();
        singleAuthor.setDescription("Test");
        singleAuthor.setName("Elsa");
        for (int i = 0; i < 11; i++) {
            authors.add(singleAuthor);
        }
        int pageNumber = 0;
        int size = 11;
        List<Author> authors_entity = AuthorMapper.dtosToEntities(authors);
        authorRepository.persist(authors_entity);
        List<AuthorDTO> authorsFromService = authorService.getAllAuthors(pageNumber, size);
        assertEquals(authorsFromService, authors);
    }
}
 */