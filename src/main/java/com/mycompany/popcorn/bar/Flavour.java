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

public class Flavour {
    private String name;

    public Flavour(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Database SQL connection method
    public void retrieveFlavoursFromDatabase() {
         try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/popcornbar", "localhost", "admin123")) {
            String query = "SELECT * FROM flavours";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String flavourName = resultSet.getString("name");
                Flavour flavour = new Flavour(flavourName);
                System.out.println(flavour.getName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
