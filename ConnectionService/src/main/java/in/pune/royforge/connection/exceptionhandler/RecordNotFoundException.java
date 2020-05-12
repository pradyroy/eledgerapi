package in.pune.royforge.connection.exceptionhandler;

public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String exception) {
		super(exception);
	}
}