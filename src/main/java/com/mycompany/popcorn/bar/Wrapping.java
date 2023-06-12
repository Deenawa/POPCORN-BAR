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

public class Wrapping {
    private String size;

    public Wrapping(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    // Database SQL connection method
    public void retrieveWrappingSizesFromDatabase() {
       try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/popcornbar", "localhost", "admin123")) {
            String query = "SELECT * FROM wrapping_sizes";
            PreparedStatement statement = connection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String size = resultSet.getString("size");
                Wrapping wrapping = new Wrapping(size);
                System.out.println(wrapping.getSize());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
