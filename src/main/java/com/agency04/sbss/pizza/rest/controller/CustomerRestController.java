package com.agency04.sbss.pizza.rest.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.rest.dto.request.CustomerInfoRequest;
import com.agency04.sbss.pizza.rest.dto.response.CustomerInfoResponse;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller for customer related request
 */
@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	/**
	 * Customer service for CRUD operations
	 */
	private final CustomerService customerService;

	public CustomerRestController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Returns customer info for given username
	 *
	 * @param username username to find customer's info
	 * @return returns customer info if customer with given username exists
	 */
	@GetMapping("/{username}")
	public ResponseEntity<CustomerInfoResponse> getCustomerInfo(@PathVariable String username) {

		if (customerService.customerExists(username))
			return new ResponseEntity<>(
					customerService.getCustomerInfo(username),
					HttpStatus.OK);
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Registers customer if username is unique
	 *
	 * @param customer customer to register
	 * @return returns HTTP created status if customer is successfully registered
	 */
	@PostMapping("")
	public ResponseEntity<?> registerCustomer(@RequestBody Customer customer) {
		if (customerService.customerExists(customer.getUsername()))
			return new ResponseEntity<>("Username already in use.", HttpStatus.BAD_REQUEST);

		CustomerInfoResponse createdCustomer = customerService.registerCustomer(customer);

		if (createdCustomer != null)
			return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);
		else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	/**
	 * Updates customer's data
	 *
	 * @param customer customer data to update
	 * @return returns HTTP OK status if data is successfully updated
	 */
	@PutMapping("")
	public ResponseEntity<?> updateCustomer(@RequestBody CustomerInfoRequest customer) {
		if (!customerService.customerExists(customer.getUsername()))
			return new ResponseEntity<>("No Such customer with username: " + customer.getUsername(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
	}

	/**
	 * Deletes customer with given username
	 *
	 * @param username username of customer to delete
	 * @return returns HTTP OK status if customer is successfully deleted
	 */
	@DeleteMapping("/{username}")
	public ResponseEntity<?> deleteCustomer(@PathVariable String username) {
		if (!customerService.customerExists(username))
			return new ResponseEntity<>("No Such customer with username: " + username, HttpStatus.NOT_FOUND);

		customerService.deleteCustomer(username);

		return new ResponseEntity<>("Customer deleted.", HttpStatus.OK);
	}
}
