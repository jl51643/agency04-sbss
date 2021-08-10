package com.agency04.sbss.pizza.rest.dto.response;

import com.agency04.sbss.pizza.model.Pizza;

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
	private Map<Pizza, Set<String>> menu;

	public PizzeriaMenu(Map<Pizza, Set<String>> menu) {
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
	public Map<Pizza, Set<String>> getMenu() {
		return menu;
	}

	/**
	 * Sets new pizzeria menu
	 *
	 * @param menu New pizzeria menu
	 */
	public void setMenu(Map<Pizza, Set<String>> menu) {
		this.menu = menu;
	}

	/**
	 * Adds one pizza to menu with available sizes
	 *
	 * @param pizza Pizza to add to menu
	 * @param sizes available pizza sizes
	 */
	public void addMenuItem(Pizza pizza, Set<String> sizes) {
		this.menu.put(pizza, sizes);
	}
}
