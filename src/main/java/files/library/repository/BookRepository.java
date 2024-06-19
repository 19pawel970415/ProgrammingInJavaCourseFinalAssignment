package files.library.repository;

import files.library.domain.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }
}
