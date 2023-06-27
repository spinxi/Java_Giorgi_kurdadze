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

public class HelloApplication extends Application {
    private ObservableList<Product> products = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Product Management");

        // Create form components
        Label nameLabel = new Label("Name:");
        TextField nameTextField = new TextField();

        Label categoryLabel = new Label("Category:");
        TextField categoryTextField = new TextField();

        Label priceLabel = new Label("Price:");
        TextField priceTextField = new TextField();

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String name = nameTextField.getText();
            String category = categoryTextField.getText();
            double price = Double.parseDouble(priceTextField.getText());

            Product product = new Product(name, price, category);
            products.add(product);

        });

        PieChart pieChart = new PieChart();
        Button refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> refreshChart());

        // Create the layout
        VBox formLayout = new VBox(10);
        formLayout.getChildren().addAll(nameLabel, nameTextField, categoryLabel, categoryTextField,
                priceLabel, priceTextField, addButton);

        VBox chartLayout = new VBox(10);
        chartLayout.getChildren().addAll(pieChart, refreshButton);

        HBox root = new HBox(10);
        root.getChildren().addAll(formLayout, chartLayout);

        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void refreshChart() {
        // Retrieve data from MySQL database using JDBC
        // ...
        // Group products using Java Stream API and populate the PieChart
        // ...
    }

    public static void main(String[] args) {
        launch(args);
    }
}