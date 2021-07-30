package com.agency04.sbss.pizza.rest.controller;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple controller containing endpoint for pizza orders
 */
@RestController
public class PizzaController {

	/**
	 * Pizza delivery service used to generate pizza order
	 */
	PizzaDeliveryService pizzaDeliveryService;

	/**
	 * Constructing controller to order pizza
	 *
	 * @param pizzaDeliveryService service used to generate pizza orders
	 */
	public PizzaController(PizzaDeliveryService pizzaDeliveryService) {
		this.pizzaDeliveryService = pizzaDeliveryService;
	}

	/**
	 * Creates pizza order via <code>PizzaDeliveryService</code>
	 *
	 * @return Returns pizza order
	 */
	@GetMapping("/")
	public String orderPizza() {
		return pizzaDeliveryService.orderPizza(new Margherita());
	}
}
