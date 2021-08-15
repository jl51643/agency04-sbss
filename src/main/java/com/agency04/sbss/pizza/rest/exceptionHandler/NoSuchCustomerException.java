package com.agency04.sbss.pizza.rest.exceptionHandler;

/**
 * Exception thrown when unregistered username occurs
 */
public class NoSuchCustomerException extends RuntimeException{

	public NoSuchCustomerException(String message) {
		super(message);
	}

	public NoSuchCustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchCustomerException(Throwable cause) {
		super(cause);
	}
}
