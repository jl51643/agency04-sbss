package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.impl.PizzaDeliveryServiceSetterInjection;
import com.agency04.sbss.pizza.service.impl.SecondPizzeria;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        PizzaDeliveryService pizzaDeliveryServiceConstructorInjection = context.getBean("pizzaDeliveryServiceConstructorInjection", PizzaDeliveryService.class);

        System.out.println(pizzaDeliveryServiceConstructorInjection.orderPizza(new Margherita()));

        PizzaDeliveryService pizzaDeliveryServiceSetterInjection = context.getBean("pizzaDeliveryServiceSetterInjection", PizzaDeliveryService.class);

        System.out.println(pizzaDeliveryServiceSetterInjection.orderPizza(new Margherita()));


        context.close();
    }

}
