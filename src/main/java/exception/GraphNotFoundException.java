package exception;

public class GraphNotFoundException extends RuntimeException {
	public GraphNotFoundException(String message) {
		super(message);
	}
}
