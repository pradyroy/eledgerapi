package in.pune.royforge.eledgerapi.data.model;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class Response {

	private Date date;
	
	private Object data;

	private String message;

	private HttpStatus responseCode;

	public Response(Date date, String message, HttpStatus errorCode) {
		super();
		this.date = date;
		this.message = message;
		this.responseCode = errorCode;
	}
	
	public Response(Date date, String message, HttpStatus errorCode, Object data) {
		super();
		this.date = date;
		this.message = message;
		this.responseCode = errorCode;
		this.data = data;
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

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}