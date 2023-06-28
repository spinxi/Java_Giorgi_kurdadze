package com.example.java_giorgi_kurdadze;

import java.sql.*;
import java.util.ArrayList;

public class getDatabaseTables {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static ArrayList<Product> getTable() {
        ArrayList<Product> productList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM products";

            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("We got results");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String category = resultSet.getString("category");
                int amount = resultSet.getInt("amount");

                Product product = new Product(name, price, category, amount);
                productList.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
}