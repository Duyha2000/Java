package Review.Example3.entries;

import Review.Example3.exceptions.BookBorrowedException;
import Review.Example3.exceptions.BookNotFoundException;
import Review.Example3.exceptions.DuplicateBookException;
import Review.Example3.exceptions.InvalidBookException;

public class Main {
    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        try {
            libraryManager.addBook("12345", "Java");
            libraryManager.addBook("45678", "Java");
            libraryManager.addBook("12345", "Java");
            System.out.println("Add successfully!");
        } catch (InvalidBookException | DuplicateBookException e) {
            System.err.println("Error:" + e.getMessage()); // 'serr' -> tab

        }

        try {
            libraryManager.removeBook("12345");
            System.out.println("Remove successfully!");
        } catch (InvalidBookException | BookNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        try {
            libraryManager.borrowBook("1234");
            System.out.println("Book borrowed successfully!");
        } catch (InvalidBookException | BookNotFoundException | BookBorrowedException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
}
