package com.agency04.sbss.pizza.rest.dto.request;

import java.util.List;
import java.util.Objects;

/**
 * Model of order form for delivery
 */
public class DeliveryOrderForm {

	/**
	 * Customer username
	 */
	private String customerUsername;

	/**
	 * List of pizzas customer ordered
	 */
	private List<PizzaOrderForm> pizzaOrders;

	public DeliveryOrderForm(String customerUsername, List<PizzaOrderForm> pizzaOrders) {
		this.customerUsername = customerUsername;
		this.pizzaOrders = pizzaOrders;
	}

	public String getCustomerUsername() {
		return customerUsername;
	}

	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}

	public List<PizzaOrderForm> getPizzaOrders() {
		return pizzaOrders;
	}

	public void setPizzaOrders(List<PizzaOrderForm> pizzaOrders) {
		this.pizzaOrders = pizzaOrders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DeliveryOrderForm that = (DeliveryOrderForm) o;
		return getCustomerUsername().equals(that.getCustomerUsername()) && getPizzaOrders().equals(that.getPizzaOrders());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCustomerUsername(), getPizzaOrders());
	}
}
