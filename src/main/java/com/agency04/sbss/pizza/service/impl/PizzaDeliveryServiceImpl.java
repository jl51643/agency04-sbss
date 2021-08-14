package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.DeliveryRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaInfo;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchPizzaException;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Concrete pizza delivery service
 */
@Service
public class PizzaDeliveryServiceImpl implements PizzaDeliveryService {

	/**
	 * Pizzeria service that handles pizza orders
	 */
	private final PizzeriaService pizzeriaService;

	/**
	 * Object conversion service
	 */
	private final ConversionService conversionService;

	/**
	 * Service used for operations with <code>Delivery</code> objects
	 */
	private final DeliveryRepository deliveryRepository;

	/**
	 * Current orders
	 */
	private List<PizzaOrder> currentOrders;

	public PizzaDeliveryServiceImpl(PizzeriaService pizzeriaService, ConversionService conversionService, DeliveryRepository deliveryRepository) {
		this.pizzeriaService = pizzeriaService;
		this.conversionService = conversionService;
		this.deliveryRepository = deliveryRepository;
	}

	@Override
	public String orderPizza(DeliveryOrderForm order) {
		Customer customer = conversionService.convert(order, Customer.class);

		List<PizzaOrder> pizzaOrderList = conversionService.convert(order, List.class);

		String orders = checkOrder(pizzaOrderList);

		this.setCurrentOrders(pizzaOrderList);


		Delivery delivery = new Delivery(customer, new Date());
		delivery.setPizzaOrders(pizzaOrderList);

		deliveryRepository.save(delivery);

		return orders;
	}

	@Override
	public PizzeriaInfo getPizzeriaInfo() {
		return new PizzeriaInfo(
				this.pizzeriaService.getName(),
				this.pizzeriaService.getAddress());
	}

	@Override
	public PizzeriaMenu getPizzeriaMenu() {
		return this.pizzeriaService.getMenu();
	}

	@Override
	public List<PizzaOrder> getCurrentOrders() {
		return this.currentOrders;
	}

	public void setCurrentOrders(List<PizzaOrder> currentOrders) {
		this.currentOrders = currentOrders;
	}

	private String checkOrder(List<PizzaOrder> pizzaOrderList) {

		String orders = pizzeriaService.getName() + " Pizzeria: \nYou ordered: \n";

		for (PizzaOrder pizzaOrder : pizzaOrderList) {

			if (!this.pizzeriaService.getMenu().getMenu().containsKey(pizzaOrder.getPizza()))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizzaOrder.getPizza().getName() + " pizza.");

			if (!this.pizzeriaService.getMenu().getMenu().get(pizzaOrder.getPizza()).contains(pizzaOrder.getSize()))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizzaOrder.getPizza().getName() + " pizza size " + pizzaOrder.getSize() + ".");

			orders += pizzaOrder.getQuantity() + " " +pizzaOrder.getSize() + " "
					+ pizzaOrder.getPizza().getName() + " pizza with ingredients "
					+ pizzaOrder.getPizza().getIngredients()
					.stream()
					.map(EPizzaIngredient::getPizzaIngredient)
					.collect(Collectors
							.joining(", "))
					+ ".\n";
		}

		return orders;
	}
}
