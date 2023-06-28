package com.example.java_giorgi_kurdadze;
public class Product {
    private String name;
    private double price;
    private String category;
    private int amount;

    public Product(String name, double price, String category, int amount) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.amount = amount;
    }

    // Getters and setters

    //name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    //amount
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    //p]rice
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    //category
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}