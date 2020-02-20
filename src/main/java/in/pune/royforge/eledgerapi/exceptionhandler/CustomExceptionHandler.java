package in.pune.royforge.eledgerapi.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex) {
		Date currentDate = new Date();
		ErrorResponse error = new ErrorResponse(currentDate, ex.getMessage(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
	}


	@ExceptionHandler(EmptyListException.class)
	public final ResponseEntity<Object> handleEmptyListException(EmptyListException ex) {
		Date currentDate = new Date();
		ErrorResponse error = new ErrorResponse(currentDate, ex.getMessage(), HttpStatus.NO_CONTENT);
		return new ResponseEntity<Object>(error, HttpStatus.NO_CONTENT);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex) {
		Date currentDate = new Date();
		ErrorResponse error = new ErrorResponse(currentDate, ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
