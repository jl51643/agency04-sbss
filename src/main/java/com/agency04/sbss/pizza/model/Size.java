package com.agency04.sbss.pizza.model;

/**
 *  Sizes of pizza
 *  {@link #SMALL}
 *  {@link #MEDIUM}
 *  {@link #LARGE}
 */
public enum Size {
	SMALL("Small"),
	MEDIUM("Medium"),
	LARGE("Large");

	private final String size;

	Size(String size) {
		this.size = size;
	}

	public String getSize() {
		return size;
	}


}
