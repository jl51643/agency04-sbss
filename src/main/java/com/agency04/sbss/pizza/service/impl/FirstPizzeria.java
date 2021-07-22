package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;

/**
 * Concrete pizzeria
 */
public class FirstPizzeria implements PizzeriaService {

	/**
	 * Name of pizzeria
	 */
	private  String name;

	/**
	 * Address of pizzeria
	 */
	private  String address;

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getAddress() {
		return this.address;
	}

	@Override
	public void makePizza(Pizza pizza) {

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
