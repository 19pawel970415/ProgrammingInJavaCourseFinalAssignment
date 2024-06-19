package files.library.service;

public class Validator implements ValidatorInterface {
    @Override
    public boolean validateTitle(String title) {
        if (title.length() > 100) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validateAuthor(String author) {
        if (author.length() > 50) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validateYearOfPublication(String yearOfPublication) {
        if (yearOfPublication.length() != 4 || !yearOfPublication.matches("\\d+")) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean validateISBN(String ISBN) {
        if (ISBN.length() != 13 || !ISBN.matches("\\d+")) {
            return false;
        } else {
            return true;
        }
    }
}
