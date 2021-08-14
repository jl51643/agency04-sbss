package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * Wrapper object for pizza ingredients
 */
@Entity
public class PizzaIngredient {

	/**
	 * Ingredient name
	 */
	@Id
	private String ingredientName;

	/**
	 * Enum value for pizza ingredient
	 */
	@Enumerated(EnumType.STRING)
	private EPizzaIngredient pizzaIngredient;

	public PizzaIngredient(EPizzaIngredient pizzaIngredient) {
		this.pizzaIngredient = pizzaIngredient;
		this.ingredientName = this.pizzaIngredient.name();
	}

	public PizzaIngredient() {

	}

	public EPizzaIngredient getPizzaIngredient() {
		return pizzaIngredient;
	}

	public void setPizzaIngredient(EPizzaIngredient pizzaIngredient) {
		this.pizzaIngredient = pizzaIngredient;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PizzaIngredient that = (PizzaIngredient) o;
		return getPizzaIngredient() == that.getPizzaIngredient();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPizzaIngredient());
	}
}
