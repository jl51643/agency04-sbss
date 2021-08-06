package com.agency04.sbss.pizza.model;

/**
 * Model of customer
 */
public class Customer {

	/**
	 * Customer username
	 */
	private String username;

	/**
	 * Customer address
	 */
	private String address;

	/**
	 * Customer phone number
	 */
	private String phone;


	///**
	// * List of all orders that user made
	// */
	//private List<PizzaOrder> orders;


	public Customer(String username, String address, String phone) {
		this.username = username;
		this.address = address;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
