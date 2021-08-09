package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaInfo;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchPizzaException;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.impl.util.factory.PizzaFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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

	private final ConversionService conversionService;

	/**
	 * Current orders
	 */
	private List<PizzaOrder> currentOrders;

	public PizzaDeliveryServiceImpl(PizzeriaService pizzeriaService, ConversionService conversionService) {
		this.pizzeriaService = pizzeriaService;
		this.conversionService = conversionService;
	}

	@Override
	public String orderPizza(DeliveryOrderForm order) {

		Customer customer = conversionService.convert(order, Customer.class);

		String orders = pizzeriaService.getName() + " Pizzeria: \nYou ordered: \n";

		List<PizzaOrder> pizzaOrderList = conversionService.convert(order, List.class);


		for (PizzaOrder pizzaOrder : pizzaOrderList) {
			Pizza pizza;
			try {
				pizza = PizzaFactory.newInstance(pizzaOrder.getPizzaName());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
				throw new NoSuchPizzaException("There is no " + pizzaOrder.getPizzaName() + " pizza.");
			}

			if (!this.pizzeriaService.getMenu().getMenu().containsKey(pizza))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizza.getName() + " pizza.");

			if (!this.pizzeriaService.getMenu().getMenu().get(pizza).contains(pizzaOrder.getSize()))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizza.getName() + " pizza size " + pizzaOrder.getSize() + ".");

			orders += pizzaOrder.getQuantity() + " " +pizzaOrder.getSize() + " "
					+ pizza.getName() + " pizza with ingredients "
					+ pizza.getIngredients()
					.stream()
					.map(PizzaIngredient::getPizzaIngredient)
					.collect(Collectors
							.joining(", "))
					+ ".\n";
		}

		this.setCurrentOrders(order.getPizzaOrders());

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
}
