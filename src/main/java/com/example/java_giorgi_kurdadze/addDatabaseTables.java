package com.example.java_giorgi_kurdadze;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class addDatabaseTables {
    private static String DB_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_java_test";
    private static String DB_USER = "freedb_java_test";
    private static String DB_PASSWORD = "8HxU4ZC7N!MnUn?";

    public static void addProduct(Product product) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO products (name, price, category) VALUES (?, ?, ?)")) {

            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getCategory());
            statement.executeUpdate();

            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}