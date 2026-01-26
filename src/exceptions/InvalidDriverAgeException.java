package exceptions;

public class InvalidDriverAgeException extends RuntimeException {
    public InvalidDriverAgeException(String message) {
        super(message);
    }
}
