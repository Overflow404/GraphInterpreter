package exception;

public class NodeAlreadyExistException extends RuntimeException {
	public NodeAlreadyExistException(String message) {
		super(message);
	}
}