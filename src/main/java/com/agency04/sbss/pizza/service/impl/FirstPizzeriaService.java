package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Concrete pizzeria
 */
@Component
public class FirstPizzeriaService implements PizzeriaService {

	/**
	 * Name of pizzeria
	 */
	@Value("My first pizzeria")
	private  String name;

	/**
	 * Address of pizzeria
	 */
	@Value("Sesame street")
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
	public String makePizza(Pizza pizza) {
		return "Pizzeria: " + getName() + "\nAddress: " + getAddress();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
