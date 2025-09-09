package Review.Example3.exceptions;

public class DuplicateBookException extends Exception {
    public DuplicateBookException(String message) {
        super(message);
    }
}
