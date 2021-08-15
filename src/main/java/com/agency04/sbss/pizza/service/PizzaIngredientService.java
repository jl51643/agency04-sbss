package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.PizzaIngredient;

public interface PizzaIngredientService {

	/**
	 * Inserts pizza ingredient to database
	 *
	 * @param ePizzaIngredient enumerated value of pizza ingredient
	 * @return returns inserted pizza ingredient
	 */
	PizzaIngredient insertPizzaIngredient(EPizzaIngredient ePizzaIngredient);
}
