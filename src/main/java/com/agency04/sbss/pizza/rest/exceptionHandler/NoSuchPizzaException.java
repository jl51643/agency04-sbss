package com.agency04.sbss.pizza.rest.exceptionHandler;

/**
 * Exception thrown when problem occurs with pizza orders
 */
public class NoSuchPizzaException extends RuntimeException{

	public NoSuchPizzaException(String message) {
		super(message);
	}

	public NoSuchPizzaException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoSuchPizzaException(Throwable cause) {
		super(cause);
	}
}
