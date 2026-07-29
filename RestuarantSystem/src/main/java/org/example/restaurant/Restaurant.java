package org.example.restaurant;

import org.example.model.Customer;
import org.example.exceptions.*;
import org.example.model.Food;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Restaurant {
    Scanner sc = new Scanner(System.in);

    Customer customer;
    Food[] menu = new Food[10];

    CreateCustomer createCustomer = new CreateCustomer();
    CreateMenu createMenu = new CreateMenu();
    ShowMenu showMenu = new ShowMenu();
    OrderFood orderFood = new OrderFood();

    public void start() {

        customer = createCustomer.createCustomer();

        createMenu.createMenu(menu);

        while (true) {

            showMenu.showMenu(menu);

            try {

                orderFood.orderFood(menu, customer);

            } catch (OutOfStockException |
                     LowBalanceException |
                     FoodNotFoundException |
                     InputMismatchException e) {

                e.printStackTrace();
                sc.nextLine();
            }

            System.out.println("1. Order again");
            System.out.println("2. Exit");

            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("Good bye");
                break;
            }
        }
    }
}