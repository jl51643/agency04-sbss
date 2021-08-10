package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;

/**
 * Model of pizzeria
 */
public interface PizzeriaService {

	/**
	 * Returns name of pizzeria
	 *
	 * @return Returns name of pizzeria
	 */
	String getName();

	/**
	 * Returns address of pizzeria
	 *
	 * @return Returns address of pizzeria
	 */
	String getAddress();

	/**
	 * Returns description of pizzeria
	 *
	 * @param pizza Pizza to make
	 */
	String makePizza(Pizza pizza);

	/**
	 * Returns pizzeria menu
	 *
	 * @return returns pizzeria menu
	 */
	PizzeriaMenu getMenu();
}
