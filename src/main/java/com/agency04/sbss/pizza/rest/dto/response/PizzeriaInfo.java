package com.agency04.sbss.pizza.rest.dto.response;

/**
 * Model of basic pizzeria info
 */
public class PizzeriaInfo {

	/**
	 * Pizzeria name
	 */
	private String pizzeriaName;

	/**
	 * Pizzeria address
	 */
	private String pizzeriaAddress;

	public PizzeriaInfo(String pizzeriaName, String pizzeriaAddress) {
		this.pizzeriaName = pizzeriaName;
		this.pizzeriaAddress = pizzeriaAddress;
	}

	public String getPizzeriaName() {
		return pizzeriaName;
	}

	public void setPizzeriaName(String pizzeriaName) {
		this.pizzeriaName = pizzeriaName;
	}

	public String getPizzeriaAddress() {
		return pizzeriaAddress;
	}

	public void setPizzeriaAddress(String pizzeriaAddress) {
		this.pizzeriaAddress = pizzeriaAddress;
	}
}
