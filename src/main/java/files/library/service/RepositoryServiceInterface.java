package files.library.service;

import files.library.domain.Book;
import files.library.repository.BookRepository;

public interface RepositoryServiceInterface {
    void addBook(BookRepository bookRepository, Book book);
    void deleteBook(BookRepository bookRepository, String ISBN);
    Book findBookByTitle(BookRepository bookRepository, String title);
    Book findBookByAuthor(BookRepository bookRepository, String author);
    Book findBookByYearOfPublication(BookRepository bookRepository, String yearOfPublication);
    Book findBookByISBN(BookRepository bookRepository, String ISBN);
    void borrowBook(BookRepository bookRepository, String ISBN);
    void giveBackBook(BookRepository bookRepository, String ISBN);
    void showAllBooks(BookRepository bookRepository);
}
