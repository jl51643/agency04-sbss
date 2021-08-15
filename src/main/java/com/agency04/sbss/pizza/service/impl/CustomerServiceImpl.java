package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.CustomerRepository;
import com.agency04.sbss.pizza.dao.DeliveryRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.rest.dto.request.CustomerInfoRequest;
import com.agency04.sbss.pizza.rest.dto.response.CustomerInfoResponse;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

/**
 * Concrete customer service
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	/**
	 * Service for operations with customers data
	 */
	private final CustomerRepository customerRepository;

	/**
	 * Service for operations with <code>Delivery</code> objects
	 */
	private final DeliveryRepository deliveryRepository;

	/**
	 * Service for type conversion
	 */
	private final ConversionService conversionService;

	public CustomerServiceImpl(CustomerRepository customerRepository, DeliveryRepository deliveryRepository, ConversionService conversionService) {
		this.customerRepository = customerRepository;
		this.deliveryRepository = deliveryRepository;
		this.conversionService = conversionService;
	}

	/**
	 * Returns customer info from database for given username
	 *
	 * @param username username of customer to look for
	 * @return returns customer info from database for given username
	 */
	@Override
	public CustomerInfoResponse getCustomerInfo(String username) {

		if (username == null)
			throw new NullPointerException("Username can not be null.");

		Customer customer;

		if (customerRepository.existsById(username))
			customer = customerRepository.findById(username).get();
		else
			throw new NoSuchElementException("There is no user with username: " + username + ".");

		return conversionService.convert(customer, CustomerInfoResponse.class);
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

		try {
			return customerRepository.existsById(username);
		} catch (IllegalArgumentException exc) {
			return false;
		}

	}

	/**
	 * Registers new customer to database
	 *
	 * @param customer new customer
	 * @return returns true if customer is successfully registered to database
	 */
	@Override
	public CustomerInfoResponse registerCustomer(Customer customer) {

		if (customer == null
				|| customer.getUsername() == null
				|| customer.getCustomerDetails() == null
				|| customer.getDeliveries() == null)
			return null;

		if (customerExists(customer.getUsername()))
			return null;

		Customer savedCustomer = customerRepository.save(customer);

		return conversionService.convert(savedCustomer, CustomerInfoResponse.class);
	}

	/**
	 * Updates customer's info.
	 * If new value of some customer data is set to <code>null</code>
	 * old value stays written to database
	 *
	 * @param customerInfo customer info to update
	 * @return returns true if customer data is successfully updated
	 */
	@Transactional
	@Override
	public CustomerInfoResponse updateCustomer(CustomerInfoRequest customerInfo) {

		if (customerInfo == null || customerInfo.getUsername() == null)
			return null;

		if (!customerRepository.existsById(customerInfo.getUsername()))
			return null;

		Customer oldCustomer = customerRepository.findById(customerInfo.getUsername()).get();

		Customer customer = new Customer(oldCustomer.getUsername(), oldCustomer.getCustomerDetails(), oldCustomer.getDeliveries());

		if (customerInfo.getFirstname() != null)
			customer.getCustomerDetails().setFirstName(customerInfo.getFirstname());

		if (customerInfo.getLastname() != null)
			customer.getCustomerDetails().setLastName(customerInfo.getLastname());


		customerRepository.updateCustomerDetails(customer.getCustomerDetails(), customerInfo.getUsername());


		Customer savedCustomer = customerRepository.findById(customerInfo.getUsername()).get();

		return conversionService.convert(savedCustomer, CustomerInfoResponse.class);
	}

	/**
	 * Deletes customer from database
	 *
	 * @param username username of customer to delete
	 */
	@Transactional
	@Override
	public void deleteCustomer(String username) {

		if (username == null)
			return;

		deliveryRepository.detachCustomerFromDelivery(username);

		customerRepository.deleteById(username);
	}

}
