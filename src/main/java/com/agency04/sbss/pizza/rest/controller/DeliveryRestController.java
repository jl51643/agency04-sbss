package com.agency04.sbss.pizza.rest.controller;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Rest controller that handles requests related to pizza deliveries
 */
@RestController
@RequestMapping("/api/delivery")
public class DeliveryRestController {

	/**
	 * Pizza delivery service for processing pizza orders
	 */
	private PizzaDeliveryService pizzaDeliveryService;

	public DeliveryRestController(PizzaDeliveryService pizzaDeliveryService) {
		this.pizzaDeliveryService = pizzaDeliveryService;
	}

	/**
	 * Returns description of received order if order is valid.
	 * Valid order contains customers information and order details
	 * of one or more pizza, size of pizza and quantity of pizza.
	 *
	 * @param deliveryOrderForm customers order
	 * @return returns description of order if order is valid
	 */
	@PostMapping("/order")
	public ResponseEntity<?> order(@RequestBody DeliveryOrderForm deliveryOrderForm) {
		Optional<String> response = pizzaDeliveryService.orderPizza(deliveryOrderForm);
		if (response.isEmpty())
			return new ResponseEntity<>("Check your order", HttpStatus.BAD_REQUEST);
		else
			return ResponseEntity.ok().body(response.get());
	}

	/**
	 * Returns list of current orders
	 *
	 * @return returns list of current orders
	 */
	@GetMapping("/list")
	public ResponseEntity<List<PizzaOrder>> listCurrentOrders () {
		return new ResponseEntity<>(pizzaDeliveryService.getCurrentOrders(), HttpStatus.OK);
	}
}
