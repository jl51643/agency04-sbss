package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.PizzaRepository;
import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaIngredientService;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.stereotype.Service;

/**
 * Service for operations with pizza objects
 */
@Service
public class PizzaServiceImpl implements PizzaService {

	/**
	 * Service for database operations with pizza objects
	 */
	private final PizzaRepository pizzaRepository;

	/**
	 * Service for operations with pizza ingredient objects
	 */
	private final PizzaIngredientService pizzaIngredientService;

	public PizzaServiceImpl(PizzaRepository pizzaRepository, PizzaIngredientService pizzaIngredientService) {
		this.pizzaRepository = pizzaRepository;
		this.pizzaIngredientService = pizzaIngredientService;
	}

	@Override
	public Pizza insertPizza(Pizza pizza) {

		for (EPizzaIngredient ingredient : pizza.getIngredients()) {
			pizzaIngredientService.insertPizzaIngredient(ingredient);
		}

		Pizza newPizza = null;
		if (!pizzaRepository.existsById(pizza.getName())) {
			newPizza = new Pizza(pizza.getName());
			newPizza.setIngredientsEnumValues(pizza.getIngredients());
			pizzaRepository.save(newPizza);
		}

		return newPizza;
	}
}
