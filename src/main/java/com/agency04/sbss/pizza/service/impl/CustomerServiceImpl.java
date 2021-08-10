package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.CustomerDatabaseHandler;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

/**
 * Concrete customer service
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/**
	 * Database handler for operations with database
	 */
	private final CustomerDatabaseHandler databaseHandler;

	public CustomerServiceImpl(CustomerDatabaseHandler databaseHandler) {
		this.databaseHandler = databaseHandler;
	}

	/**
	 * Returns customer info from database for given username
	 *
	 * @param username username of customer to look for
	 * @return returns customer info from database for given username
	 */
	@Override
	public Customer getCustomerInfo(String username) {

		if (username == null)
			throw new NullPointerException("Username can not be null.");

		if (databaseHandler.existsByUsername(username))
			return databaseHandler.getCustomerByUsername(username);
		throw new NoSuchElementException("There is no user with username: " + username + ".");
	}

	/**
	 * Returns true if customer with given username exists in database
	 *
	 * @param username username of customer to look for
	 * @return returns true if customer with given username exists in database
	 */
	@Override
	public boolean customerExists(String username) {

		if (username == null)
			return false;

		return databaseHandler.existsByUsername(username);
	}

	/**
	 * Registers new customer to database
	 *
	 * @param customer new customer
	 * @return returns true if customer is successfully registered to database
	 */
	@Override
	public boolean registerCustomer(Customer customer) {

		if (customer == null
				|| customer.getUsername() == null
				|| customer.getAddress() == null
				|| customer.getPhone() == null)
			return false;

		if (customerExists(customer.getUsername()))
			return false;

		return databaseHandler.registerCustomer(customer);
	}

	/**
	 * Updates customer's info.
	 * If new value of some customer data is set to <code>null</code>
	 * old value stays written to database
	 *
	 * @param customer customer info to update
	 * @return returns true if customer data is successfully updated
	 */
	@Override
	public boolean updateCustomer(Customer customer) {

		if (customer == null || customer.getUsername() == null)
			return false;

		Customer oldCustomer = databaseHandler.getCustomerByUsername(customer.getUsername());

		if (customer.getAddress() == null)
			customer.setAddress(oldCustomer.getAddress());

		if (customer.getPhone() == null)
			customer.setPhone(oldCustomer.getPhone());

		return databaseHandler.updateCustomer(customer);
	}

	/**
	 * Deletes customer from database
	 *
	 * @param username username of customer to delete
	 * @return returns true if user is successfully deleted
	 */
	@Override
	public boolean deleteCustomer(String username) {

		if (username == null)
			return false;

		return databaseHandler.deleteCustomer(username);
	}
}
