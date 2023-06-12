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
import java.util.Scanner;

// Data Access Object (DAO) class
class AdminDAO {
    private final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private final String DB_USER = "localhost";
    private final String DB_PASSWORD = "admin123";

    public boolean verifyAdminCredentials(String username, String password) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/popcornbar", "localhost", "admin123")) {
            String query = "SELECT * FROM admin WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            return resultSet.next();
        } catch (SQLException e) {
            return false;
        }
    }
}

// Admin login form class
public class AdminLoginForm {
    private String username;
    private String password;

    public AdminLoginForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Admin Login Form");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        AdminLoginForm adminLoginForm = new AdminLoginForm(username, password);

        // Create an instance of the DAO class
        AdminDAO adminDAO = new AdminDAO();

        // Perform login verification using the DAO class
        if (adminDAO.verifyAdminCredentials(adminLoginForm.getUsername(), adminLoginForm.getPassword())) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }

        scanner.close();
    }

    void login() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
