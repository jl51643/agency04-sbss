package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaInfo;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;

import java.util.List;

/**
 * Service used to order pizza
 */
public interface PizzaDeliveryService {

	/**
	 * Temporarily stores order and returns description of customers order
	 *
	 * @param order customer's order
	 * @return Returns description of order
	 */
	String orderPizza(DeliveryOrderForm order);

	/**
	 * Returns information about pizzeria
	 *
	 * @return Returns information about pizzeria
	 */
	PizzeriaInfo getPizzeriaInfo();

	/**
	 * Returns pizzeria menu
	 *
	 * @return Returns pizzeria menu
	 */
	PizzeriaMenu getPizzeriaMenu();

	/**
	 * Returns list of current orders
	 *
	 * @return returns list of currently submitted orders
	 */
	List<PizzaOrder> getCurrentOrders();
}
