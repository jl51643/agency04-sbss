package com.agency04.sbss.pizza.rest.dto.response;

import com.agency04.sbss.pizza.rest.dto.request.PizzaOrderForm;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Simplified model of <code>Delivery</code>
 * for retrieving information about delivery
 */
public class DeliveryPizzaOrder {

	/**
	 * Date of delivery submission
	 */
	private Date submissionDate;

	/**
	 * List of orders
	 */
	private List<PizzaOrderForm> pizzaOrders;

	public DeliveryPizzaOrder(Date submissionDate, List<PizzaOrderForm> pizzaOrders) {
		this.submissionDate = submissionDate;
		this.pizzaOrders = pizzaOrders;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
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
		DeliveryPizzaOrder that = (DeliveryPizzaOrder) o;
		return getSubmissionDate().equals(that.getSubmissionDate()) && getPizzaOrders().equals(that.getPizzaOrders());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getSubmissionDate(), getPizzaOrders());
	}
}
