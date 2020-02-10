package go.univer.service.validator;

public class ValidationException extends RuntimeException {
	public ValidationException(String msg) {
		super("(Validation Exception) " + msg);
	}
}
