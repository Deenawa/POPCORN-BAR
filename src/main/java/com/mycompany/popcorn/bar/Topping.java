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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Topping {
    private String name;

    public Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        // Database SQL connection
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/popcornbar", "localhost", "admin123")) {
            String query = "SELECT * FROM toppings";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String toppingName = resultSet.getString("name");
                Topping topping = new Topping(toppingName);
                System.out.println(topping.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
