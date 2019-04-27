package exception;

public class GraphAlreadyExistException extends RuntimeException {
	public GraphAlreadyExistException(String message) {
		super(message);
	}
}