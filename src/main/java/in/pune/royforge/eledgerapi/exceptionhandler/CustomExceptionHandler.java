package in.pune.royforge.eledgerapi.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	/*
	 * This Method is used to handle Custom Exception when data is not found in
	 * database. It will throw RecordNotFoundException
	 */
	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex) {
		return new ResponseEntity<Object>(new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND),
				HttpStatus.NOT_FOUND);
	}

	/*
	 * This Method is used to throw Exception when user enter any invalid input.
	 * Here we throw InvalidArgumentException
	 */
	@ExceptionHandler(InvalidArgumentException.class)
	public final ResponseEntity<Object> handleInvalidArgumentException(InvalidArgumentException ex) {
		return new ResponseEntity<Object>(new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.NOT_ACCEPTABLE),
				HttpStatus.NOT_ACCEPTABLE);
	}

	/*
	 * This Method will handle all types of Exceptions other than
	 * RecordNotFoundException. Here we used Exception class
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex) {
		return new ResponseEntity<Object>(
				new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}