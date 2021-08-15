package com.agency04.sbss.pizza.rest.dto.response;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.EPizzaSize;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Model of pizzeria menu containing pizza
 * and available sizes of that pizza
 */
public class PizzeriaMenu {

	/**
	 * Pizzeria menu
	 */
	private Map<Pizza, Set<EPizzaSize>> menu;

	public PizzeriaMenu(Map<Pizza, Set<EPizzaSize>> menu) {
		this.menu = menu;
	}

	public PizzeriaMenu() {
		this.menu = new HashMap<>();
	}

	/**
	 * Returns pizzeria menu
	 *
	 * @return Returns pizzeria menu
	 */
	public Map<Pizza, Set<EPizzaSize>> getMenu() {
		return menu;
	}

	/**
	 * Sets new pizzeria menu
	 *
	 * @param menu New pizzeria menu
	 */
	public void setMenu(Map<Pizza, Set<EPizzaSize>> menu) {
		this.menu = menu;
	}

	/**
	 * Adds one pizza to menu with available sizes
	 *
	 * @param pizza Pizza to add to menu
	 * @param EPizzaSizes available pizza sizes
	 */
	public void addMenuItem(Pizza pizza, Set<EPizzaSize> EPizzaSizes) {
		this.menu.put(pizza, EPizzaSizes);
	}
}
