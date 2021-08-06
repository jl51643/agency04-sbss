package com.agency04.sbss.pizza.model;

import java.util.Objects;
import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Marinara implements Pizza {

	/**
	 * Pizza name
	 */
	private final String name = "Marinara";

	/**
	 * Set of ingredients that this pizza contains
	 */
	private final Set<PizzaIngredient> ingredients =
			Set.of(PizzaIngredient.TOMATO_SAUCE,
					PizzaIngredient.GARLIC,
					PizzaIngredient.BASIL);

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Set<PizzaIngredient> getIngredients() {
		return this.ingredients;
	}

	@Override
	public String toString() {
		return this.getName();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Marinara marinara = (Marinara) o;
		return getName().equals(marinara.getName()) && getIngredients().equals(marinara.getIngredients());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getIngredients());
	}
}
