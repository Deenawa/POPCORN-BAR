/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.popcorn.bar;

/**
 *
 * @author Lenovo
 */
import java.util.ArrayList;
import java.util.List;

public class Popcorn {
    private List<Topping> toppings;
    private Wrapping wrapping;
    private Flavour flavour;
    private Customer customer;

    public Popcorn() {
        toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setWrapping(Wrapping wrapping) {
        this.wrapping = wrapping;
    }

    public void setFlavour(Flavour flavour) {
        this.flavour = flavour;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void printOrderDetails() {
        System.out.println("Popcorn Order Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Flavour: " + flavour.getName());
        System.out.println("Wrapping: " + wrapping.getSize());
        System.out.println("Toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getName());
        }
    }
}

