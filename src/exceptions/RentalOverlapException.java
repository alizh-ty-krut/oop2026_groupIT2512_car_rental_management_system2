package exceptions;

public class RentalOverlapException extends RuntimeException {
    public RentalOverlapException(String message) {
        super(message);
    }
}
