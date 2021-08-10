package com.agency04.sbss.pizza.rest.dto.request;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.PizzaOrder;

import java.util.List;

/**
 * Model of order form for delivery
 */
public class DeliveryOrderForm {

	/**
	 * Customer
	 */
	private Customer customer;

	/**
	 * List of pizzas customer ordered
	 */
	private List<PizzaOrder> pizzaOrders;

	public DeliveryOrderForm(Customer customer, List<PizzaOrder> pizzaOrders) {
		this.customer = customer;
		this.pizzaOrders = pizzaOrders;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<PizzaOrder> getPizzaOrders() {
		return pizzaOrders;
	}

	public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
		this.pizzaOrders = pizzaOrders;
	}
}
