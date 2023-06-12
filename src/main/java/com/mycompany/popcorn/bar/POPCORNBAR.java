package com.mycompany.popcorn.bar;

// AdminLoginForm class implementation

import java.util.ArrayList;
import java.util.List;

class AdminLoginForm {
    private final String username;
    private final String password;

    public AdminLoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void login() {
        System.out.println("Admin logged in successfully.");
    }
}

// Topping class implementation
class Topping {
    private final String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Wrapping class implementation
class Wrapping {
    private final String size;

    public Wrapping(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}

// Customer class implementation
class Customer {
    private final String name;
    private final String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// Flavour class implementation
class Flavour {
    private final String name;

    public Flavour(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Popcorn class implementation
class Popcorn {
    private final List<Topping> toppings;
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

public class POPCORNBAR {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Create an instance of AdminLoginForm
        AdminLoginForm adminLoginForm = new AdminLoginForm("admin", "admin123");

        // Create an instance of Topping
        Topping topping = new Topping("Caramel");

        // Create an instance of Wrapping
        Wrapping wrapping = new Wrapping("Paper");

        // Create an instance of Customer
        Customer customer = new Customer("Deenawa ", "Deenawa@gmail.com");

        // Create an instance of Flavour
        Flavour flavour = new Flavour("Butter");

        // Create an instance of Popcorn
        Popcorn popcorn = new Popcorn();

        // Perform operations with the created objects
        adminLoginForm.login();  // Perform login operation

        popcorn.addTopping(topping);  // Add topping to the popcorn
        popcorn.setWrapping(wrapping);  // Select a wrapping for the popcorn
        popcorn.setCustomer(customer);  // Set the customer for the popcorn order
        popcorn.setFlavour(flavour);  // Set the flavor for the popcorn

        // Print the order details
        popcorn.printOrderDetails();

        // Example usage:
        System.out.println("Admin Username: " + adminLoginForm.getUsername());
        System.out.println("Admin Password: " + adminLoginForm.getPassword());

        System.out.println("Topping: " + topping.getName());

        System.out.println("Wrapping: " + wrapping.getSize());

        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());

        System.out.println("Flavour: " + flavour.getName());
    }
}
