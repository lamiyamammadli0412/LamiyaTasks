package org.example.restaurant;

import org.example.model.Food;

public class ShowMenu {
    public void showMenu(Food[] menu) {
        System.out.println("- MENU -");

        for (Food food : menu) {

            System.out.println(food.getId() + ". "
                    + food.getName()
                    + " Price: "
                    + food.getPrice()
                    + " Stock: "
                    + food.getStock());

        }

    }
}
