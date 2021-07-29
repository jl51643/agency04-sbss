package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Concrete pizza delivery service
 */
@Component
@Scope("prototype")
public class PizzaDeliveryServiceSetterInjection implements PizzaDeliveryService {

	/**
	 * Pizzeria service that handles pizza orders
	 */
	private PizzeriaService pizzeriaService;

	@Autowired
	@Qualifier("secondPizzeriaService")
	public void setPizzeriaService(PizzeriaService pizzeriaService) {
		this.pizzeriaService = pizzeriaService;
	}

	@Override
	public String orderPizza(Pizza pizza) {
		String order = "";

		order += pizzeriaService.getName() + " Pizzeria: "
				+ "You ordered " + pizza.getName() + " pizza with ingredients "
				+ pizza.getIngredients()
				.stream()
				.map(PizzaIngredient::getPizzaIngredient)
				.collect(Collectors
						.joining(", "))
				+ ".";

		return order;
	}
}
