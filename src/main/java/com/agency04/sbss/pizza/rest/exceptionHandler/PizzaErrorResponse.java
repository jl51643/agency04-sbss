package com.agency04.sbss.pizza.rest.exceptionHandler;

/**
 * Response to user when error occurs
 */
public class PizzaErrorResponse {

	/**
	 * HTTP status code of error
	 */
	private int status;

	/**
	 * Message to user what caused error
	 */
	private String message;

	public PizzaErrorResponse(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public PizzaErrorResponse() {
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
