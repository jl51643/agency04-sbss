package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Concrete pizzeria
 */
public class FirstPizzeriaService implements PizzeriaService {

	/**
	 * Name of pizzeria
	 */
	private  String name;

	/**
	 * Address of pizzeria
	 */
	private  String address;

	/**
	 * Initializing values after construction of object
	 */
	@PostConstruct
	private void initializeValues() {
		this.setName("My first pizzeria");
		this.setAddress("Sesame street");
		System.out.println(this.getName() + ": Executing post construct operations...");
	}

	/**
	 * Function called before destruction of object
	 */
	@PreDestroy
	private void preDestroy() {
		System.out.println(this.getName() + ": Executing pre destroy operations...");
	}

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
