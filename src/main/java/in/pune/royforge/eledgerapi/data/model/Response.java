package in.pune.royforge.eledgerapi.exceptionhandler;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private Date date;

	private String message;

	private HttpStatus errorCode;

	public ErrorResponse(Date date, String message, HttpStatus errorCode) {
		super();
		this.date = date;
		this.message = message;
		this.errorCode = errorCode;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(HttpStatus errorCode) {
		this.errorCode = errorCode;
	}
}