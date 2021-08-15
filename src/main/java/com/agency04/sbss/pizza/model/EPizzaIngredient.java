package com.agency04.sbss.pizza.model;

/**
 * Ingredients that pizza can have
 * {@link #TOMATO_SAUCE}
 * {@link #MOZZARELLA}
 * {@link #OREGANO}
 * {@link #GARLIC}
 * {@link #BASIL}
 * {@link #HAM}
 * {@link #ARTICHOKES}
 * {@link #MUSHROOMS}
 * {@link #OLIVES}
 */

public enum EPizzaIngredient {

    TOMATO_SAUCE("tomato sauce"),
    MOZZARELLA("mozzarella"),
    OREGANO("oregano"),
    GARLIC("garlic"),
    BASIL("basil"),
    HAM("ham"),
    ARTICHOKES("artichokes"),
    MUSHROOMS("mushrooms"),
    OLIVES("olives");

    /**
     * Name of ingredient
     */
    private final String pizzaIngredient;

    /**
     * Constructs pizza ingredient with given name
     *
     * @param name name of ingredient
     */
    EPizzaIngredient(String name) {
        this.pizzaIngredient = name;
    }


    /**
     * @return Returns name of ingredient
     */
    public String getPizzaIngredient() {
        return pizzaIngredient;
    }
}
