package org.example.restaurant;

import org.example.model.Food;

public class CreateMenu {

    public void createMenu(Food[] menu) {

        menu[0] = new Food(1, "Pizza", 12, 10);
        menu[1] = new Food(2, "Burger", 8, 15);
        menu[2] = new Food(3, "Hot Dog", 6, 12);
        menu[3] = new Food(4, "Fries", 4, 20);
        menu[4] = new Food(5, "Doner", 7, 8);
        menu[5] = new Food(6, "Taco", 5, 9);
        menu[6] = new Food(7, "Shawarma", 8, 10);
        menu[7] = new Food(8, "Sandwich", 6, 11);
        menu[8] = new Food(9, "Chicken", 10, 5);
        menu[9] = new Food(10, "Nuggets", 9, 7);

    }

}
