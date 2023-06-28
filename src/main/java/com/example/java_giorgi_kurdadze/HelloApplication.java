package com.example.java_giorgi_kurdadze;

import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;


public class HelloApplication extends Application {

    private PieChart pieChart;
    @Override
    public void start(Stage primaryStage) {
        createDatabaseTables.createTable();
        primaryStage.setTitle("Product Management");

        // Form
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryTextField = new TextField();

        Label priceLabel = new Label("Price:");
        TextField priceTextField = new TextField();

        Label amountLabel = new Label("Amount:");
        TextField amountTextField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String name = nameTextField.getText();
            String category = categoryTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());
            int amount = Integer.parseInt(amountTextField.getText());

            Product product = new Product(name, price, category, amount);
            addDatabaseTables.addProduct(product);

            // Clear the form fields
            nameTextField.setText("");
            categoryTextField.setText("");
            priceTextField.setText("");
            amountTextField.setText("");

            // Refresh the chart after adding the product
            refreshChart();
        });

        // Create the layout
        VBox formLayout = new VBox(10);
        formLayout.getChildren().addAll(nameLabel, nameTextField, categoryLabel, categoryTextField,
                priceLabel, priceTextField, amountLabel, amountTextField, addButton);

        // Create the chart initially
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
        pieChart = new PieChart(pieChartData); // Initialize the PieChart field

        VBox chartLayout = new VBox(10);
        chartLayout.getChildren().addAll(pieChart);

        HBox root = new HBox(10);
        root.getChildren().addAll(formLayout, chartLayout);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        // Refresh the chart initially
        refreshChart();
    }

    // Refresh the chart with updated data
    private void refreshChart() {
        ArrayList<Product> productList = getDatabaseTables.getTable();

        if (productList != null && !productList.isEmpty()) {
            // Process the productList to group by category and calculate total amount
            Map<String, Integer> categoryWithAmount = productList.stream()
                    .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getAmount)));

            // Update the PieChart data
            ObservableList<PieChart.Data> pieChartData = pieChart.getData();
            pieChartData.clear();
            for (Map.Entry<String, Integer> entry : categoryWithAmount.entrySet()) {
                String category = entry.getKey();
                int totalAmount = entry.getValue();
                pieChartData.add(new PieChart.Data(category + " (" + totalAmount + ")", totalAmount));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}