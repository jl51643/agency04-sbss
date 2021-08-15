package com.agency04.sbss.pizza.rest.dto.response;

import java.util.LinkedList;
import java.util.List;

public class DeliveryOrderInfoResponse {

	private String pizzeriaName;

	private List<DeliveryPizzaOrderDetails> deliveryPizzaOrderDetails = new LinkedList<>();

	public DeliveryOrderInfoResponse() {
	}

	public DeliveryOrderInfoResponse(String pizzeriaName, List<DeliveryPizzaOrderDetails> deliveryPizzaOrderDetails) {
		this.pizzeriaName = pizzeriaName;
		this.deliveryPizzaOrderDetails = deliveryPizzaOrderDetails;
	}

	public String getPizzeriaName() {
		return pizzeriaName;
	}

	public void setPizzeriaName(String pizzeriaName) {
		this.pizzeriaName = pizzeriaName;
	}

	public List<DeliveryPizzaOrderDetails> getDeliveryPizzaOrderDetails() {
		return deliveryPizzaOrderDetails;
	}

	public void setDeliveryPizzaOrderDetails(List<DeliveryPizzaOrderDetails> deliveryPizzaOrderDetails) {
		this.deliveryPizzaOrderDetails = deliveryPizzaOrderDetails;
	}
}
