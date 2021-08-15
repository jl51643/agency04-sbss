package com.agency04.sbss.pizza.model;

/**
 *  Sizes of pizza
 *  {@link #SMALL}
 *  {@link #MEDIUM}
 *  {@link #LARGE}
 */
public enum EPizzaSize {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large");

	private final String size;

	EPizzaSize(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}


}
