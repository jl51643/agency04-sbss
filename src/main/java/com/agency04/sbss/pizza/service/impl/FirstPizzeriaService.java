package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.*;
import com.agency04.sbss.pizza.model.pizzaModels.Capriccosa;
import com.agency04.sbss.pizza.model.pizzaModels.Margherita;
import com.agency04.sbss.pizza.model.pizzaModels.Marinara;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * Concrete pizzeria
 */
@Service
@Primary
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
	 * Pizzeria menu
	 */
	private PizzeriaMenu menu;

	/**
	 * Initializing values after construction of object
	 */
	@PostConstruct
	private void initializeValues() {
		this.setName("My first pizzeria");

		this.setAddress("Sesame street");

		this.menu = new PizzeriaMenu();
		this.menu.addMenuItem(new Margherita(), Set.of(EPizzaSize.SMALL, EPizzaSize.MEDIUM, EPizzaSize.LARGE));
		this.menu.addMenuItem(new Capriccosa(), Set.of(EPizzaSize.SMALL, EPizzaSize.MEDIUM, EPizzaSize.LARGE));
		this.menu.addMenuItem(new Marinara(), Set.of(EPizzaSize.SMALL, EPizzaSize.MEDIUM, EPizzaSize.LARGE));
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

	@Override
	public PizzeriaMenu getMenu() {
		return this.menu;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
