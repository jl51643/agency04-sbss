package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Concrete pizza delivery service
 */
public class PizzaDeliveryServiceSetterInjection implements PizzaDeliveryService {

	/**
	 * Pizzeria service that handles pizza orders
	 */
	private PizzeriaService pizzeriaService;

	public PizzaDeliveryServiceSetterInjection() {

	}

	@Override
	public String orderPizza(Pizza pizza) {
		String order = "";

		order += pizzeriaService.getName() + " Pizzeria: "
				+ "You ordered " + pizza.getName() + " pizza with ingredients "
				+ pizza.getIngredients()
				.stream()
				.map(PizzaIngredient::getName)
				.collect(Collectors
						.joining(", "))
				+ ".";

		return order;
	}

	public void setPizzeriaService(PizzeriaService pizzeriaService) {
		this.pizzeriaService = pizzeriaService;
	}
}
