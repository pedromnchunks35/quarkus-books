package com.books.service.Book;

import java.util.List;

import org.hibernate.Hibernate;

import com.books.entity.Book;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BookService {
    @Inject
    BookRepository bookRepository;

    /**
     * @param newBook, the new Book to be inserted
     * @returns true case it got inserted, false otherwise
     */
    public boolean createBook(Book newBook) {
        bookRepository.persist(newBook);
        return bookRepository.isPersistent(newBook);
    }

    /**
     * @param BookToUpdate, the Book that we wish to update which contains its
     *                      id and the other fields
     * @return true case it got updated, false otherwise
     */
    public boolean updateBook(Book bookToUpdate) {
        bookRepository.persist(bookToUpdate);
        return bookRepository.isPersistent(bookToUpdate);
    }

    /**
     * @param BookToDelete, Book we wish to delete
     * @return true case it deleted, otherwise false
     */
    public boolean deleteBook(Book bookToDelete) {
        bookRepository.delete(bookToDelete);
        return !bookRepository.isPersistent(bookToDelete);
    }

    /**
     * @param id, the id of a Book
     * @return A Book that has that id
     */
    public Book getBookById(Long id) {
        Book Book = bookRepository.findById(id);
        return Book;
    }

    /**
     * @param pageNumber, the number of the page in accordance to the size of the
     *                    list
     * @param size,       number of items per page
     * @return List of Books
     */
    public List<Book> getAllBooks(int pageNumber, int size) {
        List<Book> Books = bookRepository.findAll()
                .page(pageNumber, size)
                .list();
        for (Book book : Books) {
            Hibernate.initialize(book.getAuthor());
        }
        return Books;
    }
}
