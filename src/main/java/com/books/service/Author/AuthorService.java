package com.books.service.Author;

import java.util.List;

import org.hibernate.Hibernate;

import com.books.entity.Author;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class AuthorService {
    @Inject
    AuthorRepository authorRepository;

    /**
     * @param newAuthor, the new author to be inserted
     * @returns true case it got inserted, false otherwise
     */
    @Transactional
    public boolean createAuthor(Author newAuthor) {
        authorRepository.persist(newAuthor);
        return authorRepository.isPersistent(newAuthor);
    }

    /**
     * @param authorToUpdate, the author that we wish to update which contains its
     *                        id and the other fields
     * @return true case it got updated, false otherwise
     */
    @Transactional
    public boolean updateAuthor(Author authorToUpdate) {
        authorRepository.persist(authorToUpdate);
        return authorRepository.isPersistent(authorToUpdate);
    }

    /**
     * @param authorToDelete, author we wish to delete
     * @return true case it deleted, otherwise false
     */
    @Transactional
    public boolean deleteAuthor(Author authorToDelete) {
        authorRepository.delete(authorToDelete);
        return !authorRepository.isPersistent(authorToDelete);
    }

    /**
     * @param id, the id of a author
     * @return A author that has that id
     */
    @Transactional
    public Author getAuthorById(Long id) {
        Author author = authorRepository.findById(id);
        return author;
    }

    /**
     * @param pageNumber, the number of the page in accordance to the size of the
     *                    list
     * @param size,       number of items per page
     * @return List of authors
     */
    @Transactional
    public List<Author> getAllAuthors(int pageNumber, int size) {
        List<Author> authors = authorRepository.findAll()
                .page(pageNumber, size)
                .list();
        for (Author author : authors) {
            Hibernate.initialize(author.getBooks());
        }
        return authors;
    }
}
