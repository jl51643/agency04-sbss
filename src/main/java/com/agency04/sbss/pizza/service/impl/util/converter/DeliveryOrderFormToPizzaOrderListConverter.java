package com.agency04.sbss.pizza.service.impl.util.converter;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.Size;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.dto.request.PizzaOrderForm;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchPizzaException;
import com.agency04.sbss.pizza.service.PizzaService;
import com.agency04.sbss.pizza.service.impl.util.factory.PizzaFactory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * Converts <code>DeliveryOrderForm</code> to list of pizza orders
 */
@Service
public class DeliveryOrderFormToPizzaOrderListConverter implements Converter<DeliveryOrderForm, List<PizzaOrder>> {

	/**
	 * Pizza service
	 */
	private final PizzaService pizzaService;

	public DeliveryOrderFormToPizzaOrderListConverter(PizzaService pizzaService) {

		this.pizzaService = pizzaService;
	}

	@Override
	public List<PizzaOrder> convert(DeliveryOrderForm order) {

		if (order.getPizzaOrders() == null || order.getPizzaOrders().size() == 0)
			throw new NoSuchPizzaException("Order must contain pizza details.");

		List<PizzaOrder> pizzaOrderList = new LinkedList<>();

		for (PizzaOrderForm pizzaOrderForm : order.getPizzaOrders()) {
			if (pizzaOrderForm.getQuantity() != null
					&& pizzaOrderForm.getSize() != null
					&& pizzaOrderForm.getPizzaName() != null) {

				Pizza pizza;
				try {
					pizza = PizzaFactory.newInstance(pizzaOrderForm.getPizzaName());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
					throw new NoSuchPizzaException("There is no " + pizzaOrderForm.getPizzaName() + " pizza.");
				}

				pizza.setName(pizza.getName());
				pizza.setIngredientsEnumValues(pizza.getIngredients());

				pizzaService.insertPizza(pizza);

				Size size = null;
				for (Size s : Size.class.getEnumConstants()) {
					if (pizzaOrderForm.getSize().equals(s.getSize())) {
						size = s;
					}
				}
				if (size == null)
					throw new NoSuchPizzaException("There is no " + pizzaOrderForm.getSize() + " size of pizza.");

				PizzaOrder pizzaOrder = new PizzaOrder(size, pizzaOrderForm.getQuantity());
				pizzaOrder.setPizza(pizza);
				pizzaOrderList.add(pizzaOrder);

			}
			else
				throw new NoSuchPizzaException("Check your order.");
		}

		return pizzaOrderList;
	}

}
