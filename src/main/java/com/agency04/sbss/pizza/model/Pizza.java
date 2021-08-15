package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Model of pizza
 */
@Entity
public class Pizza {

    /**
     * Pizza name
     */
    @Id
    private String name;

    /**
     * Pizza ingredients
     */
    @ManyToMany
    @JoinTable(name = "pizza_ingredients", joinColumns = @JoinColumn(name = "pizzaIngredient"))
    private Set<PizzaIngredient> ingredients;

    public Pizza(String name) {
        this.name = name;
    }

    public Pizza() {

    }

    /**
     * Returns name of pizza
     *
     * @return Returns Name of pizza
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns pizza ingredients
     *
     * @return Returns set of pizza ingredients
     */
    public Set<EPizzaIngredient> getIngredients() {
        Set<EPizzaIngredient> ePizzaIngredients = new HashSet<>();
        for (PizzaIngredient pizzaIngredient : this.ingredients) {
            ePizzaIngredients.add(pizzaIngredient.getPizzaIngredient());
        }

        return ePizzaIngredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(Set<PizzaIngredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setIngredientsEnumValues(Set<EPizzaIngredient> ingredients) {
        this.ingredients = ingredients.stream()
                                        .map(PizzaIngredient::new)
                                        .collect(Collectors.toSet());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return getName().equals(pizza.getName()) && getIngredients().equals(pizza.getIngredients());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getIngredients());
    }
}
