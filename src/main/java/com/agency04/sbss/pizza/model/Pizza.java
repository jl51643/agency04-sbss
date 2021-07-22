package com.agency04.sbss.pizza.model;

import java.util.Set;

/**
 * Model of pizza
 */
public interface Pizza {

    /**
     * Returns name of pizza
     *
     * @return Returns Name of pizza
     */
    String getName();

    /**
     * Returns pizza ingredients
     *
     * @return Returns set of pizza ingredients
     */
    Set<PizzaIngredient> getIngredients();
}
