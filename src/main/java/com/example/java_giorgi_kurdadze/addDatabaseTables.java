package com.example.java_giorgi_kurdadze;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class addDatabaseTables {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_test?verifyServerCertificate=false&useSSL=true";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void addProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO products (name, price, category, amount) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getCategory());
            statement.setInt(4, product.getAmount());
            statement.executeUpdate();

            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}