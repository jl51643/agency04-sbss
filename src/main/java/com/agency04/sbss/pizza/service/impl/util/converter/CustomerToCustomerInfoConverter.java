package com.agency04.sbss.pizza.service.impl.util.converter;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.PizzaOrderForm;
import com.agency04.sbss.pizza.rest.dto.response.CustomerInfoResponse;
import com.agency04.sbss.pizza.rest.dto.response.DeliveryPizzaOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Takes care of conversion from <code>Customer</code> to <code>CustomerInfoResponse</code>
 * for easier representation of customer's data
 */
@Service
public class CustomerToCustomerInfoConverter implements Converter<Customer, CustomerInfoResponse> {

	@Override
	public CustomerInfoResponse convert(Customer customer) {
		CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse(
				customer.getUsername(),
				customer.getCustomerDetails().getFirstName(),
				customer.getCustomerDetails().getLastName(),
				customer.getCustomerDetails().getPhone()
		);

		List<DeliveryPizzaOrder> deliveryPizzaOrders = new LinkedList<>();

		for (Delivery delivery : customer.getDeliveries()) {
			List<PizzaOrderForm> pizzaOrderForms = new LinkedList<>();
			for (PizzaOrder pizzaOrder : delivery.getPizzaOrders()) {
				pizzaOrderForms.add(
						new PizzaOrderForm(
								pizzaOrder.getPizza().getName(),
								pizzaOrder.getSize().getSize(),
								pizzaOrder.getQuantity()));
			}
			deliveryPizzaOrders.add(new DeliveryPizzaOrder(delivery.getSubmissionDate(), pizzaOrderForms));
		}

		customerInfoResponse.setDeliveryPizzaOrders(deliveryPizzaOrders);

		return customerInfoResponse;
	}
}
