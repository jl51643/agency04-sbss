package com.agency04.sbss.pizza.rest.dto.request;

/**
 * Data transfer object to update customers personal information
 */
public class CustomerInfoRequest {

	private String username;

	private String firstname;

	private String lastname;

	public CustomerInfoRequest(String username, String firstname, String lastname) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
}
