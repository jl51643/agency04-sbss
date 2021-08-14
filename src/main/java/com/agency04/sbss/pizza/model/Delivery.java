package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Model of delivery
 */
@Entity
public class Delivery {

	/**
	 * Unique delivery id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deliveryId;

	/**
	 * Customer who ordered delivery
	 */
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH})
	@JoinColumn(name = "username")
	private Customer customer;

	/**
	 * Date of submission of delivery
	 */
	private Date submissionDate;

	/**
	 * List of pizzas customer ordered
	 */
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<PizzaOrder> pizzaOrders;

	public Delivery(Customer customer, Date submissionDate) {
		this.customer = customer;
		this.submissionDate = submissionDate;
	}

	public Delivery() {

	}

	public long getDeliveryId() {
		return deliveryId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public List<PizzaOrder> getPizzaOrders() {
		return pizzaOrders;
	}

	public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
		this.pizzaOrders = pizzaOrders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Delivery delivery = (Delivery) o;
		return getDeliveryId() == delivery.getDeliveryId() && Objects.equals(getCustomer(), delivery.getCustomer()) && getSubmissionDate().equals(delivery.getSubmissionDate()) && getPizzaOrders().equals(delivery.getPizzaOrders());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getDeliveryId(), getCustomer(), getSubmissionDate(), getPizzaOrders());
	}
}
