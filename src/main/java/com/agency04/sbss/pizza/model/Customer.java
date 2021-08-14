package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Model of customer
 */
@Entity
public class Customer {

	/**
	 * Customer username
	 */
	@Id
	private String username;

	/**
	 * Customer detail information
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private CustomerDetails customerDetails;

	/**
	 * Customer's deliveries
	 */
	@OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	private List<Delivery> deliveries;


	public Customer(String username, CustomerDetails customerDetails, List<Delivery> deliveries) {
		this.username = username;
		this.customerDetails = customerDetails;
		this.deliveries = deliveries;
	}

	public Customer() {

	}

	public String getUsername() {
		return username;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return getUsername().equals(customer.getUsername()) && getCustomerDetails().equals(customer.getCustomerDetails()) && getDeliveries().equals(customer.getDeliveries());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getUsername(), getCustomerDetails(), getDeliveries());
	}
}
