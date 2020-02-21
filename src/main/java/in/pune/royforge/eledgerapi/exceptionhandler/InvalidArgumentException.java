package in.pune.royforge.eledgerapi.exceptionhandler;

public class InvalidArgumentException extends RuntimeException {
	public InvalidArgumentException(String exception) {
		super(exception);
	}
}