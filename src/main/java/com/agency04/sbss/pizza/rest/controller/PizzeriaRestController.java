package com.agency04.sbss.pizza.rest.controller;

import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaInfo;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller that handles requests about pizzeria info
 */
@RestController
@RequestMapping("/api/pizzeria")
public class PizzeriaRestController {

	/**
	 * Pizza delivery service with information about pizzeria
	 */
	PizzaDeliveryService pizzaDeliveryService;

	public PizzeriaRestController(PizzaDeliveryService pizzaDeliveryService) {
		this.pizzaDeliveryService = pizzaDeliveryService;
	}

	/**
	 * Returns pizzeria menu
	 *
	 * @return returns pizzeria menu
	 */
	@GetMapping("/menu")
	public ResponseEntity<PizzeriaMenu> getMenu() {
		return new ResponseEntity<>(pizzaDeliveryService.getPizzeriaMenu(), HttpStatus.OK);
	}

	/**
	 * Returns pizzeria info
	 *
	 * @return returns pizzeria info
	 */
	@GetMapping("/")
	public ResponseEntity<PizzeriaInfo> getPizzeria() {
		return new ResponseEntity<>(this.pizzaDeliveryService.getPizzeriaInfo(), HttpStatus.OK);
	}
}
