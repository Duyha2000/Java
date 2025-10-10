package Project3;

public class InvalidUserFormatException extends Exception {
    public InvalidUserFormatException(String message) {
        super(message); // quan trọng!
    }

    public InvalidUserFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
