package com.agency04.sbss.pizza.service.impl.util.converter;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchPizzaException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * Converts <code>DeliveryOrderForm</code> to list of pizza orders
 */
@Service
public class DeliveryOrderFormToPizzaOrderListConverter implements Converter<DeliveryOrderForm, List<PizzaOrder>> {

	@Override
	public List<PizzaOrder> convert(DeliveryOrderForm order) {

		if (order.getPizzaOrders() == null || order.getPizzaOrders().size() == 0)
			throw new NoSuchPizzaException("Order must contain pizza details.");

		List<PizzaOrder> pizzaOrderList = new LinkedList<>();

		for (PizzaOrder pizzaOrder : order.getPizzaOrders()) {
			if (pizzaOrder.getQuantity() > 0
					&& pizzaOrder.getSize() != null
					&& pizzaOrder.getPizzaName() != null)
				pizzaOrderList.add(pizzaOrder);
			else
				throw new NoSuchPizzaException("Check your order.");
		}

		return pizzaOrderList;
	}
}
