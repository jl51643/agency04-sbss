package com.agency04.sbss.pizza.dao;

import com.agency04.sbss.pizza.model.PizzaIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaIngredientRepository extends JpaRepository<PizzaIngredient, String> {
}
