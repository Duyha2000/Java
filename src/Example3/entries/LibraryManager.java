package Example3.entries;

import Example3.exceptions.BookBorrowedException;
import Example3.exceptions.BookNotFoundException;
import Example3.exceptions.DuplicateBookException;
import Example3.exceptions.InvalidBookException;

import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(String isbn, String title) throws InvalidBookException, DuplicateBookException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new InvalidBookException("ISBN cannot be null or empty");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new InvalidBookException("Title cannot be null or empty");
        }

        // '2'
        // [1 2 3]
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                throw new DuplicateBookException("Duplicate book");
            }
        }
        books.add(new Book(isbn, title));
    }

    public void removeBook(String isbn) throws InvalidBookException, BookNotFoundException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new InvalidBookException("isbn cannot be null or empty");
        }
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                return;
            }
        }
        throw new BookNotFoundException("Not found with ISBN");
    }

    public void borrowBook(String isbn) throws InvalidBookException, BookNotFoundException, BookBorrowedException {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new InvalidBookException("isbn cannot be null or empty");
        }
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isBorrowed()) {
                    throw new BookBorrowedException("Already borrowed");
                }
                book.setBorrowed(true);
                return;
            }
        }
        throw new BookNotFoundException("Not found with ISBN");
    }

}
