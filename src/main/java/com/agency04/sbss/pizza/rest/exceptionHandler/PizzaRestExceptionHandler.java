package com.agency04.sbss.pizza.rest.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler
 */
@ControllerAdvice
public class PizzaRestExceptionHandler {

	/**
	 * Handles <code>NoSuchPizzaException</code> exceptions
	 *
	 * @param exception NoSuchPizzaException
	 * @return Returns error message to user
	 */
	@ExceptionHandler
	public ResponseEntity<PizzaErrorResponse> handleException (NoSuchPizzaException exception) {

		return new ResponseEntity<>(
				new PizzaErrorResponse(
						HttpStatus.NOT_FOUND.value(),
						exception.getMessage()),
				HttpStatus.NOT_FOUND);
	}

	/**
	 * Handles any exception that occurs
	 *
	 * @param exception general exception
	 * @return Returns error message to user
	 */
	@ExceptionHandler
	public ResponseEntity<PizzaErrorResponse> handleException (Exception exception) {

		return new ResponseEntity<>(
				new PizzaErrorResponse(
						HttpStatus.BAD_REQUEST.value(),
						exception.getMessage()),
				HttpStatus.BAD_REQUEST);
	}

}
