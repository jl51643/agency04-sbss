package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        PizzaDeliveryService singletonBean = context.getBean("pizzaDeliveryServiceConstructorInjection", PizzaDeliveryService.class);
        PizzaDeliveryService singletonBean2 = context.getBean("pizzaDeliveryServiceConstructorInjection", PizzaDeliveryService.class);

        boolean isEqual = singletonBean == singletonBean2;

        System.out.println("Are beans equal?: " + isEqual);
        System.out.println("Singleton bean 1: " + singletonBean);
        System.out.println("Singleton bean 2: " + singletonBean2);

        System.out.println(singletonBean.orderPizza(new Margherita()));
        System.out.println(singletonBean2.orderPizza(new Margherita()));

        PizzaDeliveryService prototypeBean = context.getBean("pizzaDeliveryServiceSetterInjection", PizzaDeliveryService.class);
        PizzaDeliveryService prototypeBean2 = context.getBean("pizzaDeliveryServiceSetterInjection", PizzaDeliveryService.class);

        isEqual = prototypeBean == prototypeBean2;

        System.out.println("Are beans equal?: " + isEqual);
        System.out.println("prototype bean 1: " + prototypeBean);
        System.out.println("prototype bean 2: " + prototypeBean2);

        System.out.println(prototypeBean.orderPizza(new Margherita()));
        System.out.println(prototypeBean2.orderPizza(new Margherita()));



        context.close();
    }

}
