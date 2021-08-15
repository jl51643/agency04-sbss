package com.agency04.sbss.pizza.service.impl.util.factory;

import com.agency04.sbss.pizza.model.Pizza;

import java.lang.reflect.InvocationTargetException;

/**
 * Pizza objects factory
 */
public class PizzaFactory {

	/**
	 * Creates <code>Pizza</code> object from pizza name
	 *
	 * @param pizzaName name of pizza
	 * @return returns concrete <code>Pizza</code> object based on pizza name
	 * @throws InstantiationException instantiation exception
	 * @throws IllegalAccessException illegal access exception
	 * @throws ClassNotFoundException class not found exception
	 * @throws NoSuchMethodException no such method exception
	 * @throws InvocationTargetException invocation target exception
	 */
	public static Pizza newInstance(String pizzaName) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

		Class<Pizza> clazz;
		clazz = (Class<Pizza>) Class.forName("com.agency04.sbss.pizza.model.pizzaModels." + pizzaName);

		return clazz.getConstructor().newInstance();
	}
}
