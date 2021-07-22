package com.agency04.sbss.pizza.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Marinara implements Pizza {

	@Override
	public String getName() {
		return "Marinara";
	}

	@Override
	public Set<PizzaIngredient> getIngredients() {
		Set<PizzaIngredient> ingredients = new HashSet<>();
		ingredients.add(PizzaIngredient.TOMATO_SAUCE);
		ingredients.add(PizzaIngredient.GARLIC);
		ingredients.add(PizzaIngredient.BASIL);

		return ingredients;
	}
}
