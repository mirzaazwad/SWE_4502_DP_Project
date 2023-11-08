package org.example;

import Lab4.ChicagoPizzaStore;
import Lab4.NYPizzaStore;
import Lab4.Pizza;
import Lab4.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyPizzaStore=new NYPizzaStore();
        Pizza pizza=nyPizzaStore.orderPizza("cheese");
        System.out.println("Ethan ordered "+pizza.getName());
        PizzaStore chicagoPizzaStore=new ChicagoPizzaStore();
        Pizza pizza2=chicagoPizzaStore.orderPizza("clam");
        System.out.println("Joel ordered "+pizza2.toString());



    }
}
