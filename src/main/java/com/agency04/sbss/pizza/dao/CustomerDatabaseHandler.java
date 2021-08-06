package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.Customer;

/**
 * Handles operations with customers database
 */
public interface CustomerDatabaseHandler {

	/**
	 * Checks if user with given username exists in customer_database
	 *
	 * @param username username to look for
	 * @return returns if user with given username exists, false otherwise
	 */
	boolean existsByUsername(String username);

	/**
	 * Returns <code>Customer</code> with given username if exists
	 *
	 * @param username username of customer
	 * @return returns <code>Customer</code> with given username if exists, null otherwise
	 */
	Customer getCustomerByUsername (String username);

	/**
	 * Registers user to customer_database with given data
	 *
	 * @param customer customer data to store in customer_database
	 * @return returns true is customer is successfully added to customer_database, false otherwise
	 */
	boolean registerCustomer(Customer customer);

	/**
	 * Updates customer data if customer exists
	 *
	 * @param customer customer with data to update
	 * @return returns true if customer data is successfully updated, false otherwise
	 */
	boolean updateCustomer(Customer customer);

	/**
	 * Deletes customer with given username from customer_database
	 *
	 * @param username username of customer to delete
	 * @return returns true if customer is successfully deleted, false otherwise
	 */
	boolean deleteCustomer(String username);

}
