package files.library.service;

public interface ValidatorInterface {
    boolean validateTitle(String title);
    boolean validateAuthor(String author);
    boolean validateYearOfPublication(String yearOfPublication);
    boolean validateISBN(String ISBN);
}
