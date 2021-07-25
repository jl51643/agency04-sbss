package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

/**
 * Service used to order pizza
 */
public interface PizzaDeliveryService {

	/**
	 *
	 *
	 * @param pizza Pizza to order
	 * @return Returns description of order
	 */
	String orderPizza(Pizza pizza);
}
