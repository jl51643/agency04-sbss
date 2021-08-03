package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Concrete pizza delivery service
 */
public class PizzaDeliveryServiceConstructorInjection implements PizzaDeliveryService {

	/**
	 * Pizzeria service that handles pizza orders
	 */
	private PizzeriaService pizzeriaService;

	public PizzaDeliveryServiceConstructorInjection(PizzeriaService pizzeriaService) {
		this.pizzeriaService = pizzeriaService;
	}

	@Override
	public String orderPizza(Pizza pizza) {
		return pizzeriaService.getName() + " Pizzeria: "
				+ "You ordered " + pizza.getName() + " pizza with ingredients "
				+ pizza.getIngredients()
				.stream()
				.map(PizzaIngredient::getPizzaIngredient)
				.collect(Collectors
						.joining(", "))
				+ ".";
	}

}
