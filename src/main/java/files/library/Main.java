package files.library;

import files.library.domain.Book;
import files.library.repository.BookRepository;
import files.library.service.RepositoryService;
import files.library.service.RepositoryServiceInterface;
import files.library.service.Validator;
import files.library.service.ValidatorInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //2. Napisz aplikację konsolową w języku Java maven, która zarządza zbiorami
        //książek w bibliotece. Aplikacja powinna umożliwiać dodawanie, usuwanie,
        //wyszukiwanie książek oraz wypożyczanie i zwracanie książek. Przy tworzeniu
        //funkcjonalności programu użyj odpowiednich interfejsów. Pamiętaj o zasadzie
        //pojedynczej odpowiedzialności.
        //Dodawanie książek:
        //• Użytkownik podaje informacje o książce (tytuł, autor, rok wydania, ISBN) i
        //dodaje ją do systemu.
        //• Wszystkie pola są obowiązkowe i powinny posiadać walidację:
        //o tytuł – 100 znaków
        //o autor – 100 – 50 znaków
        //o rok wydania - 4-cyfry
        //o ISBN - 13-cyfr
        //• Jeżeli książka o danym numerze ISBN istnieje w bibliotece, program zwiększa
        //jej ilość o 1.
        //Usuwanie książek:
        //• Użytkownik podaje ISBN książki do usunięcia z systemu.
        //• Jeżeli podany ISBN nie istnieje, program powinien podać taką informację.
        //• Jeżeli w bibliotece znajduje się więcej niż jedna książka o podanym numerze
        //ISBN, program zmniejsza jej ilość o 1.
        //• Jeżeli ilość wynosi 0, książka jest usuwana z biblioteki.
        //Wyszukiwanie książek:
        //• Wyszukiwanie książek według różnych kryteriów (tytuł, autor, rok wydania).
        //• Program zwraca wszystkie książki spełniające kryterium (wyświetlenie na
        //ekranie).
        //Wypożyczanie i zwracanie książek:
        //• Użytkownik wypożycza książkę, podając jej ISBN. Program sprawdza czy na
        //stanie jest wystarczająca liczba książek do wypożyczenia.
        //• Użytkownik zwraca książkę, podając jej ISBN. Program sprawdza czy książka o
        //podanym numerze ISBN jest wypożyczona i może być zwrócona.
        //Wyświetlanie wszystkich książek:
        //• Lista wszystkich książek dostępnych w bibliotece z informacją o ilości oraz
        //informacji.

        final BookRepository bookRepository = new BookRepository();
        final RepositoryServiceInterface repositoryService = new RepositoryService();
        final ValidatorInterface validator = new Validator();

        System.out.println("Welcome to the library!");
        Scanner scanner = new Scanner(System.in);
        boolean wantExit = false;
        while (!wantExit) {
            System.out.println("Choose a number to: ");
            System.out.println("Add a book - 1");
            System.out.println("Delete a book - 2");
            System.out.println("Find a book - 3");
            System.out.println("Borrow a book - 4");
            System.out.println("Give a book back - 5");
            System.out.println("Show all books - 6");
            System.out.println("Exit the library - 7");

            if (scanner.hasNextInt()) {
                int optionNumber = scanner.nextInt();
                if (optionNumber >= 1 && optionNumber <= 7) {
                    scanner.nextLine();
                    switch (optionNumber) {
                        case 1:
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
                            String ISBN;
                            do {
                                System.out.println("Enter the ISBN: ");
                                ISBN = scanner.nextLine();
                                isCorrectISBN = validator.validateISBN(ISBN);
                            } while (!isCorrectISBN);
                            Book newBookToAdd = new Book();
                            newBookToAdd.setTitle(title);
                            newBookToAdd.setAuthor(author);
                            newBookToAdd.setPublicationYear(yearOfPublication);
                            newBookToAdd.setISBN(ISBN);
                            newBookToAdd.setNumberOfBooks(0);
                            repositoryService.addBook(bookRepository, newBookToAdd);
                            break;
                        case 2:
                            String ISBNToDelete;
                            boolean isISBNToDeleteCorrect = false;
                            do {
                                System.out.println("Enter a correct ISBN: ");
                                ISBNToDelete = scanner.nextLine();
                                isISBNToDeleteCorrect = validator.validateISBN(ISBNToDelete);
                            } while (!isISBNToDeleteCorrect);
                            repositoryService.deleteBook(bookRepository, ISBNToDelete);
                            break;
                        case 3:
                            System.out.println("Choose a number to: ");
                            System.out.println("Find a book by the title - 1");
                            System.out.println("Find a book by the author - 2");
                            System.out.println("Find a book by the year of publication - 3");
                            System.out.println("Find a book by the ISBN - 4");
                            if (scanner.hasNextInt()) {
                                int findOptionNumber = scanner.nextInt();
                                if (findOptionNumber >= 1 && findOptionNumber <= 4) {
                                    scanner.nextLine();
                                    switch (findOptionNumber) {
                                        case 1:
                                            String titleToFind;
                                            boolean isTitleCorrect = false;
                                            do {
                                                System.out.println("Enter a correct title: ");
                                                titleToFind = scanner.nextLine();
                                                isTitleCorrect = validator.validateTitle(titleToFind);
                                            } while (!isTitleCorrect);
                                            Book bookByTitle = repositoryService.findBookByTitle(bookRepository, titleToFind);
                                            if (bookByTitle.getTitle() != null) {
                                                System.out.println(bookByTitle.toString());
                                            }
                                            break;
                                        case 2:
                                            String authorToFind;
                                            boolean isAuthorCorrect = false;
                                            do {
                                                System.out.println("Enter a correct author: ");
                                                authorToFind = scanner.nextLine();
                                                isAuthorCorrect = validator.validateAuthor(authorToFind);
                                            } while (!isAuthorCorrect);

                                            Book bookByAuthor = repositoryService.findBookByAuthor(bookRepository, authorToFind);

                                            if (bookByAuthor.getAuthor() != null) {
                                                System.out.println(bookByAuthor.toString());
                                            }
                                            break;
                                        case 3:
                                            String yearToFind;
                                            boolean isYearCorrect;
                                            do {
                                                System.out.println("Enter a correct year of publication: ");
                                                yearToFind = scanner.nextLine();
                                                isYearCorrect = validator.validateYearOfPublication(yearToFind);
                                            } while (!isYearCorrect);
                                            Book bookByYear = repositoryService.findBookByYearOfPublication(bookRepository, yearToFind);
                                            if (bookByYear.getPublicationYear() != null) {
                                                System.out.println(bookByYear.toString());
                                            }
                                            break;
                                        case 4:
                                            String isbnToFind;
                                            boolean isIsbnCorrect;
                                            do {
                                                System.out.println("Enter a correct ISBN: ");
                                                isbnToFind = scanner.nextLine();
                                                isIsbnCorrect = validator.validateISBN(isbnToFind);
                                            } while (!isIsbnCorrect);

                                            Book bookByIsbn = repositoryService.findBookByISBN(bookRepository, isbnToFind);

                                            if (bookByIsbn.getISBN() != null) {
                                                System.out.println(bookByIsbn.toString());
                                            }
                                            break;
                                    }
                                } else {
                                    System.out.println("IncorrectInput!");
                                }
                            }
                            break;
                        case 4:
                            String ISBNToBorrow;
                            boolean isISBNToBorrowCorrect = false;
                            do {
                                System.out.println("Enter a correct ISBN: ");
                                ISBNToBorrow = scanner.nextLine();
                                isISBNToBorrowCorrect = validator.validateISBN(ISBNToBorrow);
                            } while (!isISBNToBorrowCorrect);
                            repositoryService.borrowBook(bookRepository, ISBNToBorrow);
                            break;
                        case 5:
                            boolean isCorrectISBNToGiveBack = false;
                            String ISBNToGiveBack;
                            do {
                                System.out.println("Enter the ISBN: ");
                                ISBNToGiveBack = scanner.nextLine();
                                isCorrectISBNToGiveBack = validator.validateISBN(ISBNToGiveBack);
                            } while (!isCorrectISBNToGiveBack);
                            repositoryService.giveBackBook(bookRepository, ISBNToGiveBack);
                            break;
                        case 6:
                            repositoryService.showAllBooks(bookRepository);
                            break;
                        case 7:
                            System.out.println("See you soon!");
                            wantExit = true;
                            break;
                    }
                } else {
                    System.out.println("Incorrect input!");
                }
            } else {
                System.out.println("Incorrect input!");
                scanner.next();
            }
        }
    }
}
