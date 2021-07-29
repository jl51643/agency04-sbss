package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService pizzaDeliveryServiceConstructorInjection = context.getBean("pizzaDeliveryServiceConstructorInjection", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryServiceConstructorInjection.orderPizza(new Margherita()));

        PizzaDeliveryService pizzaDeliveryServiceSetterInjection = context.getBean("pizzaDeliveryServiceSetterInjection", PizzaDeliveryService.class);
        System.out.println(pizzaDeliveryServiceSetterInjection.orderPizza(new Margherita()));

        context.close();
    }

}
