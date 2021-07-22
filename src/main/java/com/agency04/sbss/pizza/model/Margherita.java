package com.agency04.sbss.pizza.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Margherita implements Pizza {

    @Override
    public String getName() {
        return "Margherita";
    }

    @Override
    public Set<PizzaIngredient> getIngredients() {
        Set<PizzaIngredient> ingredients = new HashSet<>();
        ingredients.add(PizzaIngredient.TOMATO_SAUCE);
        ingredients.add(PizzaIngredient.MOZZARELLA);
        ingredients.add(PizzaIngredient.OREGANO);

        return ingredients;
    }
}
