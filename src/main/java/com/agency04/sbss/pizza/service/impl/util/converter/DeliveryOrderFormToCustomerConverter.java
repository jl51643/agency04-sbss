package com.agency04.sbss.pizza.service.impl.util.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

/**
 * Converts <code>DeliveryOrderForm</code> to <code>Customer</code>
 */
@Service
public class DeliveryOrderFormToCustomerConverter implements Converter<DeliveryOrderForm, Customer> {

	@Override
	public Customer convert(DeliveryOrderForm deliveryOrderForm) {

		if (deliveryOrderForm.getCustomer() == null
				|| deliveryOrderForm.getCustomer().getUsername() == null
				|| deliveryOrderForm.getCustomer().getAddress() == null
				|| deliveryOrderForm.getCustomer().getPhone() == null)
			throw new NullPointerException("Customer personal data missing.");

		return new Customer(
				deliveryOrderForm.getCustomer().getUsername(),
				deliveryOrderForm.getCustomer().getAddress(),
				deliveryOrderForm.getCustomer().getPhone());
	}
}
