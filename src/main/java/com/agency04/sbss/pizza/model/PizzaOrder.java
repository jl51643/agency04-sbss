package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Model of one type of pizza in customer's oder
 */
@Entity
public class PizzaOrder {

	/**
	 * Unique pizza order id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pizzaOrderId;

	/**
	 * Pizza which is ordered
	 */
	@ManyToOne
	@JoinColumn(name = "pizza_name")
	private Pizza pizza;

	/**
	 * Size of Pizza
	 */
	@Enumerated(EnumType.STRING)
	private EPizzaSize EPizzaSize;

	/**
	 * Number of ordered pizzas
	 */
	private String quantity;

	public PizzaOrder(EPizzaSize EPizzaSize, String quantity) {
		this.EPizzaSize = EPizzaSize;
		this.quantity = quantity;
	}

	public PizzaOrder() {
	}

	public long getPizzaOrderId() {
		return pizzaOrderId;
	}

	public void setPizzaOrderId(long pizzaOrderId) {
		this.pizzaOrderId = pizzaOrderId;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public EPizzaSize getSize() {
		return EPizzaSize;
	}

	public void setSize(EPizzaSize EPizzaSize) {
		this.EPizzaSize = EPizzaSize;
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
		PizzaOrder that = (PizzaOrder) o;
		return getPizzaOrderId() == that.getPizzaOrderId() && getPizza().equals(that.getPizza()) && getSize() == that.getSize() && getQuantity().equals(that.getQuantity());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPizzaOrderId(), getPizza(), getSize(), getQuantity());
	}
}
