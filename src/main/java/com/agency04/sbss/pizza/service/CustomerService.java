package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.rest.dto.request.CustomerInfoRequest;
import com.agency04.sbss.pizza.rest.dto.response.CustomerInfoResponse;

/**
 * Model of customer service
 */
public interface CustomerService {

	/**
	 * Returns customer info from database for given username
	 *
	 * @param username username of customer to look for
	 * @return returns customer info from database for given username
	 */
	CustomerInfoResponse getCustomerInfo(String username);

	/**
	 * Returns true if customer with given username exists in database
	 *
	 * @param username username of customer to look for
	 * @return returns true if customer with given username exists in database
	 */
	boolean customerExists(String username);

	/**
	 * Registers new customer to database
	 *
	 * @param customer new customer
	 * @return returns true if customer is successfully registered to database
	 */
	CustomerInfoResponse registerCustomer(Customer customer);

	/**
	 * Updates customer's info.
	 * If new value of some customer data is set to <code>null</code>
	 * old value stays written to database
	 *
	 * @param customer customer info to update
	 * @return returns true if customer data is successfully updated
	 */
	CustomerInfoResponse updateCustomer(CustomerInfoRequest customer);

	/**
	 * Deletes customer from database
	 *
	 * @param username username of customer to delete
	 */
	void deleteCustomer(String username);
}
