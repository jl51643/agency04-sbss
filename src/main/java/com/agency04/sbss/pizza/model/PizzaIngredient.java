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
public enum PizzaIngredient {

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
     * name of ingredient
     */
    public final String name;

    /**
     * Constructs pizza ingredient with given name
     *
     * @param name name of ingredient
     */
    PizzaIngredient(String name) {
        this.name = name;
    }

    /**
     * @return Returns name of ingredient
     */
    public String getName() {
        return name;
    }
}
