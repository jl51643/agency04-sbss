package com.agency04.sbss.pizza.model;


import javax.persistence.*;
import java.util.Objects;

/**
 * Personal information about customer
 */
@Entity
public class CustomerDetails {

	/**
	 * Customer's first name
	 */
	private String firstName;

	/**
	 * Customer's last name
	 */
	private String lastName;

	/**
	 * Customer's phone number
	 */
	@Id
	@Column(unique = true)
	private String phone;

	public CustomerDetails() {
	}

	public CustomerDetails(String firstName, String lastName, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CustomerDetails that = (CustomerDetails) o;
		return getFirstName().equals(that.getFirstName()) && getLastName().equals(that.getLastName()) && getPhone().equals(that.getPhone());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName(), getPhone());
	}
}
