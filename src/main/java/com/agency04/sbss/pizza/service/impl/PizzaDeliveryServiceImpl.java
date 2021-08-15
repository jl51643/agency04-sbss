package com.agency04.sbss.pizza.service.impl;

import com.agency04.sbss.pizza.dao.DeliveryRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.rest.dto.request.DeliveryOrderForm;
import com.agency04.sbss.pizza.rest.dto.response.DeliveryOrderInfoResponse;
import com.agency04.sbss.pizza.rest.dto.response.DeliveryPizzaOrderDetails;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaInfo;
import com.agency04.sbss.pizza.rest.dto.response.PizzeriaMenu;
import com.agency04.sbss.pizza.rest.exceptionHandler.NoSuchPizzaException;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

	public PizzaDeliveryServiceImpl(PizzeriaService pizzeriaService, ConversionService conversionService, DeliveryRepository deliveryRepository) {
		this.pizzeriaService = pizzeriaService;
		this.conversionService = conversionService;
		this.deliveryRepository = deliveryRepository;
	}

	@Override
	public DeliveryOrderInfoResponse orderPizza(DeliveryOrderForm order) {
		Customer customer = conversionService.convert(order, Customer.class);

		List<PizzaOrder> pizzaOrderList = conversionService.convert(order, List.class);

		DeliveryOrderInfoResponse orders = checkOrder(pizzaOrderList);

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
		List<Delivery> deliveries = deliveryRepository.findTop10ByOrderBySubmissionDateDesc();
		List<PizzaOrder> pizzaOrders = new LinkedList<>();
		for (Delivery delivery : deliveries) {
			pizzaOrders.addAll(delivery.getPizzaOrders());
		}

		return pizzaOrders;
	}

	private DeliveryOrderInfoResponse checkOrder(List<PizzaOrder> pizzaOrderList) {

		DeliveryOrderInfoResponse deliveryOrderInfoResponse = new DeliveryOrderInfoResponse();
		deliveryOrderInfoResponse.setPizzeriaName(pizzeriaService.getName());

		for (PizzaOrder pizzaOrder : pizzaOrderList) {
			if (!this.pizzeriaService.getMenu().getMenu().containsKey(pizzaOrder.getPizza()))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizzaOrder.getPizza().getName() + " pizza.");

			if (!this.pizzeriaService.getMenu().getMenu().get(pizzaOrder.getPizza()).contains(pizzaOrder.getSize()))
				throw new NoSuchPizzaException("Pizzeria do not serve " + pizzaOrder.getPizza().getName() + " pizza size " + pizzaOrder.getSize() + ".");

			DeliveryPizzaOrderDetails deliveryPizzaOrderDetails =
					new DeliveryPizzaOrderDetails(
							pizzaOrder.getPizza(),
							pizzaOrder.getSize(),
							pizzaOrder.getQuantity()
					);

			deliveryOrderInfoResponse.getDeliveryPizzaOrderDetails().add(deliveryPizzaOrderDetails);
		}

		return deliveryOrderInfoResponse;
	}
}
