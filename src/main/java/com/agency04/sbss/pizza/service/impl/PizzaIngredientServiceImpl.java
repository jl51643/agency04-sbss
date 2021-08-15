package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.PizzaIngredientRepository;
import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import com.agency04.sbss.pizza.service.PizzaIngredientService;
import org.springframework.stereotype.Service;

/**
 * Service fof operations with pizza ingredients
 */
@Service
public class PizzaIngredientServiceImpl implements PizzaIngredientService {

	/**
	 * Service for database operations with pizza ingredients
	 */
	private final PizzaIngredientRepository pizzaIngredientRepository;

	public PizzaIngredientServiceImpl(PizzaIngredientRepository pizzaIngredientRepository) {
		this.pizzaIngredientRepository = pizzaIngredientRepository;
	}


	@Override
	public PizzaIngredient insertPizzaIngredient(EPizzaIngredient ePizzaIngredient) {
		PizzaIngredient pizzaIngredient = new PizzaIngredient(ePizzaIngredient);
		if (!pizzaIngredientRepository.existsById(pizzaIngredient.getIngredientName()))
			pizzaIngredientRepository.save(pizzaIngredient);

		return pizzaIngredient;
	}
}
