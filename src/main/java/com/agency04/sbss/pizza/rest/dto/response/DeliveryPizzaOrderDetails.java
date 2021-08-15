package com.agency04.sbss.pizza.rest.dto.response;

import com.agency04.sbss.pizza.model.EPizzaSize;
import com.agency04.sbss.pizza.model.Pizza;

public class DeliveryPizzaOrderDetails {

	private Pizza pizza;

	private EPizzaSize ePizzaSize;

	private String quantity;

	public DeliveryPizzaOrderDetails() {
	}
	public DeliveryPizzaOrderDetails(Pizza pizza, EPizzaSize ePizzaSize, String quantity) {
		this.pizza = pizza;
		this.ePizzaSize = ePizzaSize;
		this.quantity = quantity;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public EPizzaSize getEPizzaSize() {
		return ePizzaSize;
	}

	public void setEPizzaSize(EPizzaSize ePizzaSize) {
		this.ePizzaSize = ePizzaSize;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
