package com.agency04.sbss.pizza.rest.dto.request;

import java.util.Objects;

/**
 * Simplified form for pizza orders
 */
public class PizzaOrderForm {

	/**
	 * Name of pizza
	 */
	private String pizzaName;

	/**
	 * Size of pizza
	 */
	private String size;

	/**
	 * Quantity of pizza
	 */
	private String quantity;

	public PizzaOrderForm(String pizzaName, String size, String quantity) {
		this.pizzaName = pizzaName;
		this.size = size;
		this.quantity = quantity;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PizzaOrderForm that = (PizzaOrderForm) o;
		return getPizzaName().equals(that.getPizzaName()) && getSize().equals(that.getSize()) && getQuantity().equals(that.getQuantity());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPizzaName(), getSize(), getQuantity());
	}
}
