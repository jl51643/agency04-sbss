package com.agency04.sbss.pizza.service.impl.util.converter;

import com.agency04.sbss.pizza.dao.CustomerRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchCustomerException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Converts <code>DeliveryOrderForm</code> to <code>Customer</code>
 */
@Service
public class DeliveryOrderFormToCustomerConverter implements Converter<DeliveryOrderForm, Customer> {

	private final CustomerRepository customerRepository;

	public DeliveryOrderFormToCustomerConverter(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer convert(DeliveryOrderForm deliveryOrderForm) {

		if (deliveryOrderForm.getCustomerUsername() == null)
			throw new NullPointerException("Customer personal data missing.");

		if (customerRepository.findById(deliveryOrderForm.getCustomerUsername()).isPresent()) {
			return customerRepository.findById(deliveryOrderForm.getCustomerUsername()).get();
		} else {
			throw new NoSuchCustomerException("There is no customer with username " + deliveryOrderForm.getCustomerUsername() + ".");
		}
	}
}
