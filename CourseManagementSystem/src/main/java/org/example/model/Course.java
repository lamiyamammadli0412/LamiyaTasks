package org.example.model;

public class Course {

    private int id;
    private String name;
    private double price;
    private int quota;

    public Course(int id, String name, double price, int quota) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quota = quota;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuota() {
        return quota;
    }

    public void decreaseQuota() {
        quota--;
    }

    @Override
    public String toString() {
        return id + ". " + name +
                " | Price: " + price +
                " AZN | Quota: " + quota;
    }
}