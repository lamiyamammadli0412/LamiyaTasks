package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private String surname;
    private double balance;
    private List<Course> myCourses;

    public User(String name, String surname, double balance) {
        this.name = name;
        this.surname = surname;
        this.balance = balance;
        this.myCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getBalance() {
        return balance;
    }

    public List<Course> getMyCourses() {
        return myCourses;
    }

    public void addBalance(double amount) {
        balance += amount;
    }

    public void pay(double amount) {
        balance -= amount;
    }

    public void addCourse(Course course) {
        myCourses.add(course);
    }
}