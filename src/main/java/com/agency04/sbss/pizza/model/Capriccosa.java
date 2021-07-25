package com.agency04.sbss.pizza.model;

import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Capriccosa implements Pizza {

	/**
	 * Pizza name
	 */
	private final String name = "Capriccosa";

	/**
	 * Set of ingredients that this pizza contains
	 */
	private final Set<PizzaIngredient> ingredients =
			Set.of(PizzaIngredient.TOMATO_SAUCE,
					PizzaIngredient.MOZZARELLA,
					PizzaIngredient.HAM,
					PizzaIngredient.ARTICHOKES,
					PizzaIngredient.MUSHROOMS,
					PizzaIngredient.OLIVES);

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Set<PizzaIngredient> getIngredients() {
		return this.ingredients;
	}
}
