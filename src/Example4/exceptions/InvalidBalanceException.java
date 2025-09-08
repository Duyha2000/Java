package Example4.exceptions;

public class InvalidBalanceException extends Exception {
    public InvalidBalanceException(String message) {
        super(message);
    }
}
