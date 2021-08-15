package com.agency04.sbss.pizza.rest.dto.response;

import java.util.LinkedList;
import java.util.List;

/**
 * Data transfer object for customer's personal data
 */
public class CustomerInfoResponse {

	/**
	 * Customer's username
	 */
	private String username;

	/**
	 * Customer's firs name
	 */
	private String firstName;

	/**
	 * Customer's last name
	 */
	private String lastName;

	/**
	 * Customer's phone number
	 */
	private String phone;

	/**
	 * List of customers orders
	 */
	List<DeliveryPizzaOrder> deliveryPizzaOrders = new LinkedList<>();

	public CustomerInfoResponse(String username, String firstName, String lastName,
								String phone) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
	}

	public void setDeliveryPizzaOrders(List<DeliveryPizzaOrder> deliveryPizzaOrders) {
		this.deliveryPizzaOrders = deliveryPizzaOrders;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<DeliveryPizzaOrder> getDeliveryPizzaOrders() {
		return deliveryPizzaOrders;
	}
}
