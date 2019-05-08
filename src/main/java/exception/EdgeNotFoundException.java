package exception;

public class EdgeNotFoundException extends RuntimeException {
    public EdgeNotFoundException(String message) {
        super(message);
    }
}