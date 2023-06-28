package com.example.java_giorgi_kurdadze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDatabaseTables {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "amount INT NOT NULL," +
                    "category VARCHAR(50) NOT NULL" +
                    ")";

            statement.executeUpdate(sql);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}