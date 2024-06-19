package files.library.service;

import files.library.domain.Book;
import files.library.repository.BookRepository;

import java.util.Scanner;

public class RepositoryService implements RepositoryServiceInterface {

    @Override
    public void addBook(BookRepository bookRepository, Book book) {
        Book bookToAdd = this.findBookByISBN(bookRepository, book.getISBN());
        boolean isInRepo = false;
        for (Book b : bookRepository.getBooks()) {
            if (b.getISBN().equals(book.getISBN())) {
                b.setNumberOfBooks(b.getNumberOfBooks() + 1);
                isInRepo = true;
                break;
            }
        }
        if (!isInRepo) {
            book.setNumberOfBooks(1);
            bookRepository.getBooks().add(book);
        }
        System.out.println("The book added successfully!");
    }

    @Override
    public void deleteBook(BookRepository bookRepository, String ISBN) {
        Boolean isBookInRepository = false;
        Book bookToDelete = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                isBookInRepository = true;
                bookToDelete = book;
            }
        }
        if (isBookInRepository) {
            if (bookToDelete.getNumberOfBooks() > 1) {
                bookToDelete.setNumberOfBooks(bookToDelete.getNumberOfBooks() - 1);
                System.out.println("The book deleted successfully!");
            } else {
                bookRepository.getBooks().remove(bookToDelete);
                System.out.println("The book deleted successfully!");
            }
        } else {
            System.out.println("No such book is our library");
        }
    }

    @Override
    public Book findBookByTitle(BookRepository bookRepository, String title) {
        boolean isFound = false;
        Book foundBook = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getTitle().equals(title)) {
                isFound = true;
                foundBook = book;
            }
        }
        if (!isFound) {
            System.out.println("No book found!");
             return foundBook;
        } else {
            return foundBook;
        }
    }

    @Override
    public Book findBookByAuthor(BookRepository bookRepository, String author) {
        boolean isFound = false;
        Book foundBook = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getAuthor().equals(author)) {
                isFound = true;
                foundBook = book;
            }
        }
        if (!isFound) {
            System.out.println("No book found!");
        }
        return foundBook;
    }

    @Override
    public Book findBookByYearOfPublication(BookRepository bookRepository, String yearOfPublication) {
        boolean isFound = false;
        Book foundBook = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getPublicationYear().equals(yearOfPublication)) {
                isFound = true;
                foundBook = book;
            }
        }
        if (!isFound) {
            System.out.println("No book found!");
        }
        return foundBook;
    }


    @Override
    public Book findBookByISBN(BookRepository bookRepository, String ISBN) {
        boolean isFound = false;
        Book foundBook = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                isFound = true;
                foundBook = book;
            }
        }
        if (!isFound) {
            System.out.println("No book found!");
        }
        return foundBook;
    }


    @Override
    public void borrowBook(BookRepository bookRepository, String ISBN) {
        Boolean isBookInRepository = false;
        Book bookToDelete = new Book();
        for (Book book : bookRepository.getBooks()) {
            if (book.getISBN().equals(ISBN)) {
                isBookInRepository = true;
                bookToDelete = book;
            }
        }
        if (isBookInRepository) {
            if (bookToDelete.getNumberOfBooks() > 1) {
                bookToDelete.setNumberOfBooks(bookToDelete.getNumberOfBooks() - 1);
                System.out.println("The book borrowed successfully!");
            } else {
                bookRepository.getBooks().remove(bookToDelete);
                System.out.println("The book borrowed successfully!");
            }
        } else {
            System.out.println("No such book is our library");
        }
    }

    @Override
    public void giveBackBook(BookRepository bookRepository, String ISBN) {
        Book bookToGiveBack = this.findBookByISBN(bookRepository, ISBN);
        boolean isInRepo = false;
        for (Book b : bookRepository.getBooks()) {
            if (b.getISBN().equals(bookToGiveBack.getISBN())) {
                b.setNumberOfBooks(b.getNumberOfBooks() + 1);
                isInRepo = true;
                break;
            }
        }
        if (!isInRepo) {
            Scanner scanner = new Scanner(System.in);
            ValidatorInterface validator = new Validator();
            boolean isCorrectTitle = false;
            String title;
            do {
                System.out.println("Enter the title: ");
                title = scanner.nextLine();
                isCorrectTitle = validator.validateTitle(title);
            } while (!isCorrectTitle);
            boolean isCorrectAuthor = false;
            String author;
            do {
                System.out.println("Enter the author: ");
                author = scanner.nextLine();
                isCorrectAuthor = validator.validateAuthor(author);
            } while (!isCorrectAuthor);
            boolean isCorrectYearOfPublication = false;
            String yearOfPublication;
            do {
                System.out.println("Enter the year of publication: ");
                yearOfPublication = scanner.nextLine();
                isCorrectYearOfPublication = validator.validateYearOfPublication(yearOfPublication);
            } while (!isCorrectYearOfPublication);
            boolean isCorrectISBN = false;
            bookToGiveBack.setTitle(title);
            bookToGiveBack.setAuthor(author);
            bookToGiveBack.setPublicationYear(yearOfPublication);
            bookToGiveBack.setISBN(ISBN);
            bookToGiveBack.setNumberOfBooks(1);
            this.addBook(bookRepository, bookToGiveBack);
        }
        System.out.println("The book given back successfully!");
    }

    @Override
    public void showAllBooks(BookRepository bookRepository) {
        for (Book book : bookRepository.getBooks()) {
            System.out.print(book.getTitle() + " ");
            System.out.print(book.getAuthor() + " ");
            System.out.print(book.getPublicationYear() + " ");
            System.out.print(book.getISBN() + " ");
            System.out.println(book.getNumberOfBooks());
            System.out.println();
        }

    }
}
