package com.agency04.sbss.pizza.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Capriccosa implements Pizza {

	@Override
	public String getName() {
		return "Capriccosa";
	}

	@Override
	public Set<PizzaIngredient> getIngredients() {
		Set<PizzaIngredient> ingredients = new HashSet<>();
		ingredients.add(PizzaIngredient.TOMATO_SAUCE);
		ingredients.add(PizzaIngredient.MOZZARELLA);
		ingredients.add(PizzaIngredient.HAM);
		ingredients.add(PizzaIngredient.ARTICHOKES);
		ingredients.add(PizzaIngredient.MUSHROOMS);
		ingredients.add(PizzaIngredient.OLIVES);

		return ingredients;
	}
}
