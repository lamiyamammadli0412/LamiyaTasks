package org.example.restaurant;

import org.example.model.Customer;
import org.example.exceptions.InvalidNameException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateCustomer {
    Scanner sc = new Scanner(System.in);
    Customer customer;

    public Customer createCustomer() {
        System.out.print("Name: ");
        String name = sc.next();
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isLetter(name.charAt(i))) {
                throw new InputMismatchException("Name must contain only letters.");
            }
        }
        if (name.length() < 3) {
            throw new InvalidNameException("Name must contain at least 3 characters.");
        }
        System.out.print("Surname: ");
        String surname = sc.next();
        for (int i = 0; i < surname.length(); i++) {
            if (!Character.isLetter(surname.charAt(i))) {
                throw new InputMismatchException("Surname must contain only letters.");
            }
        }
        if (surname.length() < 3) {
            throw new InvalidNameException("Name must contain at least 3 characters.");
        }
        System.out.print("Balance: ");

        double balance;

        try {
            balance = sc.nextDouble();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Balance must be a number.");
        }

        customer = new Customer(name, surname, balance);
        return customer;
    }
}
