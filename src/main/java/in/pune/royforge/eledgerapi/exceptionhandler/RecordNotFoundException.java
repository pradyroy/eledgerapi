package in.pune.royforge.eledgerapi.exceptionhandler;

public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String exception) {
		super(exception);
	}
}