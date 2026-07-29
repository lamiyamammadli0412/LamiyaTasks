package org.example.restaurant;

import org.example.model.Customer;
import org.example.exceptions.FoodNotFoundException;
import org.example.exceptions.LowBalanceException;
import org.example.exceptions.OutOfStockException;
import org.example.model.Food;

import java.util.Scanner;

public class OrderFood {
    Scanner sc = new Scanner(System.in);

    public void orderFood(Food[] menu, Customer customer) {

        System.out.print("Food id: ");
        int id = sc.nextInt();

        System.out.print("Quantity: ");
        int quantity = sc.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than 0.");
            return;
        }

        boolean found = false;

        for (Food food : menu) {

            if (food.getId() == id) {

                found = true;

                if (food.getStock() < quantity) {
                    throw new OutOfStockException("Not enough stock!");
                }

                double total = food.getPrice() * quantity;

                if (customer.getBalance() < total) {
                    throw new LowBalanceException("Balance is not enough!");
                }

                customer.setBalance(customer.getBalance() - total);
                food.setStock(food.getStock() - quantity);


                System.out.println("Order completed successfully!");
                System.out.println("Food: " + food.getName());
                System.out.println("Quantity: " + quantity);
                System.out.println("Total: " + total + " AZN");
                System.out.println("Remaining Balance: " + customer.getBalance() + " AZN");
                System.out.println("Remaining Stock of " + food.getName() + ": " + food.getStock());
                return;
            }

        }

        if (!found) {
            throw new FoodNotFoundException("");
        }
    }
}
