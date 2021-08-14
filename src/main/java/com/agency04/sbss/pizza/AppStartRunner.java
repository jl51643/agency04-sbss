package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerDetails;
import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.pizzaModels.Capriccosa;
import com.agency04.sbss.pizza.service.CustomerService;
import com.agency04.sbss.pizza.service.PizzaIngredientService;
import com.agency04.sbss.pizza.service.PizzaService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

@Component
public class AppStartRunner implements ApplicationRunner {

	private final PizzaIngredientService pizzaIngredientService;

	private final PizzaService pizzaService;

	private final CustomerService customerService;

	public AppStartRunner(PizzaIngredientService pizzaIngredientService, PizzaService pizzaService, CustomerService customerService) {

		this.pizzaIngredientService = pizzaIngredientService;
		this.pizzaService = pizzaService;
		this.customerService = customerService;
	}

	@Override
	public void run(ApplicationArguments args) {

		insertPizzaEntities();
		insertPizzaIngredientEntities();
		insertCustomerEntities();

	}

	private void insertCustomerEntities() {
		customerService.registerCustomer(new Customer("Josip123", new CustomerDetails("Josip", "Lukacevic", "123"), new LinkedList<>()));

	}

	private void insertPizzaIngredientEntities() {
		pizzaIngredientService.insertPizzaIngredient(EPizzaIngredient.BASIL);
		pizzaIngredientService.insertPizzaIngredient(EPizzaIngredient.ARTICHOKES);
		pizzaIngredientService.insertPizzaIngredient(EPizzaIngredient.MOZZARELLA);
		pizzaIngredientService.insertPizzaIngredient(EPizzaIngredient.TOMATO_SAUCE);

	}

	private void insertPizzaEntities() {
		pizzaService.insertPizza(new Capriccosa());
	}
}
