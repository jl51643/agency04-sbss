package com.agency04.sbss.pizza.model.pizzaModels;

import com.agency04.sbss.pizza.model.EPizzaIngredient;
import com.agency04.sbss.pizza.model.Pizza;

import java.util.Objects;
import java.util.Set;

/**
 * Model of pizza representing concrete pizza
 */
public class Margherita extends Pizza {

    /**
     * Pizza name
     */
    private final String name = "Margherita";

    /**
     * Set of ingredients that this pizza contains
     */
    private final Set<EPizzaIngredient> ingredients =
            Set.of(EPizzaIngredient.TOMATO_SAUCE,
                    EPizzaIngredient.MOZZARELLA,
                    EPizzaIngredient.OREGANO);

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Set<EPizzaIngredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Margherita that = (Margherita) o;
        return getName().equals(that.getName()) && getIngredients().equals(that.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIngredients());
    }
}
