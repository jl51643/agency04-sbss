package com.agency04.sbss.pizza.model;

import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Margherita implements Pizza {

    /**
     * Pizza name
     */
    private final String name = "Margherita";

    /**
     * Set of ingredients that this pizza contains
     */
    private final Set<PizzaIngredient> ingredients =
            Set.of(PizzaIngredient.TOMATO_SAUCE,
                    PizzaIngredient.MOZZARELLA,
                    PizzaIngredient.OREGANO);

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        return this.ingredients;
    }
}
