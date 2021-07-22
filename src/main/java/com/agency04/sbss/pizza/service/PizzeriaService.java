package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

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
	 * Returns address of pizeria
	 *
	 * @return Returns address of pizzeria
	 */
	String getAddress();

	/**
	 *
	 * @param pizza Pizza to make
	 */
	void makePizza(Pizza pizza);
}
