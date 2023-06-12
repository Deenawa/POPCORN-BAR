/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.popcorn.bar;

/**
 *
 * @author Lenovo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private String name;
    private String email;

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

    // Database SQL connection method to add customer to the database
    public void addCustomerToDatabase() {
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/popcornbar", "localhost", "admin123")) {
            String query = "INSERT INTO customers (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            statement.setString(2, email);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Customer added to the database successfully.");
            } else {
                System.out.println("Failed to add customer to the database.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

