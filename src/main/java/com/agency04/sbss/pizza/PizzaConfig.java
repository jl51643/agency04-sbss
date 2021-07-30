package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.impl.FirstPizzeriaService;
import com.agency04.sbss.pizza.service.impl.PizzaDeliveryServiceConstructorInjection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Class used to determine configurations
 */
@Configuration
@ComponentScan("com.agency04.sbss.pizza")
public class PizzaConfig {

	/**
	 * Creates and returns bean with ID "firstPizzeriaService"
	 * of type <code>PizzeriaService</code>
	 *
	 * @return Returns concrete <code>PizzeriaService</code>
	 */
	@Bean
	public PizzeriaService firstPizzeriaService() {

		return new FirstPizzeriaService();
	}

	/**
	 * Creates and returns bean with ID "pizzaDeliveryServiceConstructorInjection"
	 * of type <code>PizzaDeliveryService</code>
	 *
	 * @return Returns concrete <code>PizzaDeliveryService</code>
	 */
	@Bean
	@Primary
	public PizzaDeliveryService pizzaDeliveryServiceConstructorInjection() {

		return new PizzaDeliveryServiceConstructorInjection(firstPizzeriaService());
	}
}
