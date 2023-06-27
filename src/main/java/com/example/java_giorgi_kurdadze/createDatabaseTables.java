package com.example.java_giorgi_kurdadze;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createDatabaseTables {

    private static String DB_URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_java_test";
    private static String DB_USER = "freedb_java_test";
    private static String DB_PASSWORD = "8HxU4ZC7N!MnUn?";

    public static void main(String[] args) {
        createTable();
    }

    private static void createTable() {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS products (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "name VARCHAR(100) NOT NULL," +
                    "price DOUBLE NOT NULL," +
                    "category VARCHAR(50) NOT NULL" +
                    ")";

            statement.executeUpdate(sql);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}